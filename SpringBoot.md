## 模块总览

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)

### 1. Annotion - IOC

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image004.jpg)

例子

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image006.jpg)

@Documented -> 给注解的注解，表明该注解会显示在文档上

@Retention -> 注解的生命周期，分别对应.java, .class和字节码

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image008.jpg)

@Target 注解的作用范围

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image010.jpg)

### 2. IOC实现

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image012.jpg)

#### （1）BeanDefinition Bean的定义（接口）

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image014.jpg)

#### （2）BeanDefinitionRegistry将bean的定义信息BeanDefinition注册到BeanDefinition容器中

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image016.jpg)

#### （3）BeanFactory

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image018.jpg)

#### （4）ClassSetHelper 类集合助手，可扫描配置文件中的包路径，获得指定类型或被指定注解的类对象集合

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image020.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image022.jpg)

###### A.   获取所有类（单例构造）

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image024.jpg)

###### B.   获取被@Component注解的类

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image026.jpg)

###### C.   获取被@Service注解的类

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image028.jpg)

###### D.   获取被@Controller注解的类

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image030.jpg)

###### E.   通过超类获取类的集合

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image032.jpg)

###### F.   获取基础包下直接带有某注解的所有类

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image034.jpg)

###### G.  获取基础包下间接带有某注解的所有类

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image036.jpg)

###### H.   判断classz是否有注解annoClass，包括直接和间接的注解

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image038.jpg)

#### （5）DefaultBeanFactory 默认BeanFactory实现类

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image040.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image042.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image044.jpg)

###### A. 单例构造BeanFactory实例（双重校验懒加载， 三重缓存解决循环依赖

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image046.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image048.jpg)

###### B. 根据Bean名称获取Bean对象

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image050.jpg)

###### C. 根据Bean类型获取Bean对象

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image052.jpg)

###### D. 设置Bean

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image054.jpg)

###### E. 重新注入所有bean

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image056.jpg)

###### F. 利用configure配置Bean

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image058.jpg)

###### G. 获取bean，如果不存在就创建Bean

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image060.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image062.jpg)

###### H. 三级缓存避免循环依赖

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image064.jpg)

###### I. 依赖注入（@Value，@Autowired和@Resource）

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image066.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image068.jpg)

###### J. 工具类，根据类型或名称找到对应的类

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image070.jpg)

#### （6）GenericBeanDefinition (BeanDefinition的实现类)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image072.jpg)

#### （7）ObjectFactory (三级缓存的工厂)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image074.jpg)

## 3. Annotion-MVC

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image076.jpg)

## 4. MVC实现

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image078.jpg)

#### (1) DispatcherServlet

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image080.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image082.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image084.jpg)

###### A. 全局变量，除工厂类共享，其他均为Servlet对象私有

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image086.jpg)

###### B. Init 根据config配置serlet对象

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image088.jpg)

###### C. Freemaker的初始化

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image090.jpg)

###### D. 注册默认Servlet

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image092.jpg)

###### E. 解析url和Method的关系

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image094.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image096.jpg)

###### F. 适配器，动态匹配参数

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image098.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image100.jpg)

###### G. Get和Post实现

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image102.jpg)

###### H. 创造请求

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image104.jpg)

###### I. 根据请求找到对应的Handler

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image106.jpg)

###### J. 根据Handler找到对应的适配器

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image108.jpg)

###### K. 处理相似请求

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image110.jpg)

###### L. 处理请求，执行方法，解析结果

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image112.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image114.jpg)

#### (2) Handler定义

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image116.jpg)

#### (3) Request定义

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image118.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image120.jpg)

###### A. 方法名和路径都一样就是相同的对象

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image122.jpg)

###### B. 比较路径是否一致

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image124.jpg)

###### C. 解析路径

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image126.jpg)

#### (4) Handler适配器

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image128.jpg)

###### A.根据handler调用method

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image130.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image132.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image134.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image136.jpg)

###### B.将请求的Body转化为字符串

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image138.jpg)

#### (5) ModelAndView实例

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image140.jpg)

#### (6) ResultResolverHandler 处理三种返回类型

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image142.jpg)

## 5. Annotation-AOP

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image144.jpg)

## 6. AOP实现

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image146.jpg)

#### (1).Advice-增强类(切面，增强方法和等级)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image148.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image150.jpg)

#### (2). AOPHelper

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image152.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image154.jpg)

###### A.单例构造Aop工厂

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image156.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image158.jpg)

###### B. 扫描所有被Aop接口注释的类

 

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image160.jpg)![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image162.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image164.jpg)

###### C. 为目标类和方法找到相应的增强列表

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image166.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image168.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image170.jpg)

###### D. 分割@Pointcut的参数，获得类名和方法名

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image172.jpg)

###### E. 获得切点的value

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image174.jpg)

#### (3).CGLibProxy

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image176.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image178.jpg)

###### A. 基本参数和构造器

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image180.jpg)

###### B. 通过CGLib进行建立代理对象

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image182.jpg)

###### C. 重写CGLib代理的拦截器方法

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image184.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image186.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image188.jpg) ![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image190.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image192.jpg)

###### D. 执行增强通知

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image194.jpg)

###### E. 获取事务对象

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image196.jpg)

###### F. 四种事务操作

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image198.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image200.jpg)

#### (4) JoinPoint

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image202.jpg)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image204.jpg)

###### A.   构造方法

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image206.jpg)

###### B.    代理方法(连接点方法)

![img](file:///C:/Users/I569683/AppData/Local/Temp/msohtmlclip1/01/clip_image208.jpg)
