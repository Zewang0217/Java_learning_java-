package org.zewang.Service;

import java.util.List;
import org.zewang.pojo.User;

public interface UserService {
    /**
     * 查询所有用户
     */
    public List<User> findAll();

}
