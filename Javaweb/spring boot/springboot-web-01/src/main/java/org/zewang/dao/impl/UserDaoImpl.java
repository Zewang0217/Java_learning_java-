package org.zewang.dao.impl;

import cn.hutool.core.io.IoUtil;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.zewang.dao.UserDao;

@Repository("userDao") // 将类交给IOC容器管理
public class UserDaoImpl implements UserDao {
    public List<String> findAll() {
        // 1.读取user.txt文件，获取用户数据
        // InputStream in = new FileInputStream(new File("D:\\Zewang\\Web-AI-code\\web-ai-proj\\springboot-web-01\\src\\main"))
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
