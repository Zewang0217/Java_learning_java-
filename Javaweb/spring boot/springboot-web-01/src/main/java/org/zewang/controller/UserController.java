package org.zewang.controller;

import cn.hutool.core.io.IoUtil;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zewang.pojo.User;

/**
 * 用户信息控制器
 */
@RestController // ResponseBody -> 将controller方法的返回值直接作为响应体的数据直接响应；返回值是对象/集合->json->响应
public class UserController {

    @RequestMapping("/list")
    public List<User> list() {
        // 1.读取user.txt文件，获取用户数据
        // InputStream in = new FileInputStream(new File("D:\\Zewang\\Web-AI-code\\web-ai-proj\\springboot-web-01\\src\\main"))
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        if (in == null) {
            throw new RuntimeException("user.txt 文件未找到");
        }
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        // 2.解析用户信息，封装为user对象 -> list集合
        List<User> userList = lines.stream()
            .filter(line -> !line.trim().isEmpty()) // 过滤掉空行
            .map(line -> {
            String[] parts = line.split(","); // 字符串分割
            if (parts.length != 6) {
                throw new IllegalArgumentException("user.txt 文件格式错误: " + line);
            }
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList()); // 将流中的元素收集到一个不可变的List中

        // 3.返回用户信息（json）
        return userList; // 服务器会转换为json在传递
    }
}
