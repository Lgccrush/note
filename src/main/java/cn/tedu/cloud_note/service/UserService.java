package cn.tedu.cloud_note.service;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 用户类的服务层
 *
 * @author L
 */

public interface UserService {
    //	检查用户名和密码的方法
    public NoteResult<User> checkLogin(String name, String password);
}
