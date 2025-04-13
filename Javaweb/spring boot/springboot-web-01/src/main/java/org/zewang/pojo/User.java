package org.zewang.pojo;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id; // 项目开发中，建议使用包装类代替基础类型，防止默认值造成干扰
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;

}
