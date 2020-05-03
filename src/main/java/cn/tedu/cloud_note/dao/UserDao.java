package cn.tedu.cloud_note.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.cloud_note.entity.User;

/**
 * 用户类的持久层
 *
 * @author L
 */
public interface UserDao {
    public User findByName(String Name);//通过名字查出用户的方法

    public void save(User user);//添加用户
}
