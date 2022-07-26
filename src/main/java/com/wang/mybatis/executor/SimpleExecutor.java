package com.wang.mybatis.executor;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.wang.mybatis.core.MapperHelper;
import com.wang.mybatis.core.SqlResultCache;
import com.wang.mybatis.handler.PreparedStatementHandler;
import com.wang.mybatis.handler.ResultSetHandler;
import com.wang.mybatis.transaction.TransactionFactory;
import com.wang.mybatis.transaction.TransactionManager;
import com.wang.mybatis.transaction.TransactionStatus;

/**
 * 简单执行器
 * @author Administrator
 *
 */

public class SimpleExecutor implements Executor{

    //事务管理器
    public TransactionManager transactionManager;

    //sql缓存
    public SqlResultCache sqlResultCache;

    public SimpleExecutor(boolean openTransaction, boolean openCache){
        if(openCache){
            this.sqlResultCache = new SqlResultCache();
        }
        if(openTransaction){
            this.transactionManager = TransactionFactory.newTransaction(Connection.TRANSACTION_REPEATABLE_READ,false);
        } else {
            //默认级别为可重复读
            this.transactionManager = TransactionFactory.newTransaction();
        }
    }
    /**
     * 执行select语句
     */
    @Override
    public <E> List<E> select(Method method, Object[] args) throws Exception{
        //根据方法的类名，方法名和参数生成字符串Key
        String cacheKey = generateCacheKey(method, args);
        //如果有缓存，则直接返回
        if(sqlResultCache != null && sqlResultCache.getCache(cacheKey) != null){
            System.out.println("this is cache");
            return (List<E>) sqlResultCache.getCache(cacheKey);
        }
        //生成PreparedStatement对象，注入参数，并执行查询
        PreparedStatementHandler preparedStatementHandler = new PreparedStatementHandler(transactionManager, method, args);
        PreparedStatement preparedStatement = (PreparedStatement) preparedStatementHandler.generateStatement();
        ResultSet resultSet = null;
        preparedStatement.executeQuery();
        resultSet = preparedStatement.getResultSet();
        //对结果集resultSet进行解析，映射为实例对象
        Class<?> returnClass = MapperHelper.getMethodDetails(method).getReturnType();
        if (returnClass == null || void.class.equals(returnClass)){
            preparedStatement.close();
            preparedStatementHandler.closeConnection();
            return null;
        } else {
            ResultSetHandler resultSetHandler = new ResultSetHandler(returnClass, resultSet);
            List<E> res = resultSetHandler.handle();
            if(sqlResultCache != null){
                //将查询结果放入sql缓存中
            	sqlResultCache.putCache(cacheKey, res);
            }
            preparedStatement.close();
            resultSet.close();
            preparedStatementHandler.closeConnection();
            return res;
        }
    }
    /**
     * 执行update,insert,delete等sql语句
     */
    @Override
    public int update(Method method, Object[] args)throws SQLException{
        PreparedStatementHandler preparedStatementHandler = null;
        PreparedStatement preparedStatement = null;
        Integer count = 0;
        //执行update操作要清理缓存池，防止后续查询结果不一致
        if (sqlResultCache != null){
        	sqlResultCache.cleanCache();
        }
        try {
            preparedStatementHandler = new PreparedStatementHandler(transactionManager, method, args);
            preparedStatement = (PreparedStatement) preparedStatementHandler.generateStatement();
            count = preparedStatement.executeUpdate();
        } finally {
            // 关闭sql执行管道
            if (preparedStatement != null){
                preparedStatement.close();
            }
            preparedStatementHandler.closeConnection();
        }
        return count;
    }
    
    @Override
    public void commit(TransactionStatus status) throws SQLException {
        transactionManager.commit(status);
    }

    @Override
    public void rollback() throws SQLException {
        transactionManager.rollback();
    }

    @Override
    public void close() throws SQLException {
        transactionManager.close();
    }
    /**
     * 生成缓存sql执行结果的key
     * @param method
     * @param args
     * @return
     */
    private String generateCacheKey(Method method, Object args[]){
        //先拼接类名和方法名
        StringBuilder cacheKey = new StringBuilder(method.getDeclaringClass().getName() + method.getName());
        //再拼接参数
        for(Object o : args){
            cacheKey.append(o.toString());
        }
        return cacheKey.toString();
    }
}
