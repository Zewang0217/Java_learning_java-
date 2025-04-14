package org.zewang.Service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zewang.Service.UserService;
import org.zewang.dao.UserDao;
import org.zewang.dao.impl.UserDaoImpl;
import org.zewang.pojo.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired // 应用程序运行时，会自动查询该类型的bean对象，并赋值给成员变量，从而实现依赖注入
    private UserDao userDao;
    public List<User> findAll() {
        // 1. 调用dao获取数据
        List<String> lines = userDao.findAll();

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

        return userList;
    }
}
