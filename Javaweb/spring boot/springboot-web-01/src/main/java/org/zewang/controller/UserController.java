package org.zewang.controller;

import cn.hutool.core.io.IoUtil;
import jakarta.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zewang.Service.UserService;
import org.zewang.Service.impl.UserServiceImpl;
import org.zewang.pojo.User;

/**
 * 用户信息控制器
 */
@RestController // ResponseBody -> 将controller方法的返回值直接作为响应体的数据直接响应；返回值是对象/集合->json->响应
public class UserController {
    //方法一：属性注入
    // @Autowired
    // private UserService userService;

    //方法二：构造器注入
//    private final UserService userService;
//    @Autowired // 如果当前类中只存在一个构造函数，则@Autowired可以省略
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //方法三：setter注入
//    private UserService userService;
//    // @Qualifier("userServiceImpl")
//    @Autowired // @Autowired可以省略

    @Resource(name = "userServiceImpl2")
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> list() {

        // 调用service
        List<User> userList =  userService.findAll();

        // 返回用户信息（json）
        return userList; // 服务器会转换为json在传递
    }
}
