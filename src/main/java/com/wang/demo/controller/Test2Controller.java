package com.wang.demo.controller;

import com.wang.demo.model.ResponseEntity;
import com.wang.demo.model.User;
import com.wang.demo.service.Impl.UserServiceImpl;
import com.wang.spring.annotation.ioc.Autowired;
import com.wang.spring.annotation.mvc.*;

@Controller
@RequestMapping("/test")
public class Test2Controller {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getUser")
    @ResponseBody
    public ResponseEntity getUser() throws Exception {
        User user = userService.findUser(1);
        return ResponseEntity.success(user);
    }
}
