package cn.tedu.cloud_note.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteException;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

/**
 * 用户类服务层的实现类
 *
 * @author L
 */
@Service("userService")//扫描的spring容器
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao dao;

    public NoteResult<User> checkLogin(String name, String password) {
//		接收结果数据
        NoteResult<User> result = new NoteResult<User>();
        User user = dao.findByName(name);
//		判断是否登录成功
        if (user == null) {
//			用户名不存在的请况
            result.setStatus(1);
            result.setMsg("用户名不存在");
            return result;
        }
//		用户名存在再判断密码

        //将用户输入的明文密码加密
        String md5Password = NoteUtil.md5(password);
        if (!user.getCn_user_password().equals(md5Password)) {
//			密码错误的请况
            result.setStatus(2);
            result.setMsg("密码错误");
            return result;
        }
//		用户名和密码都正确的请况
        result.setStatus(0);
        result.setMsg("登录成功");
        result.setData(user);
        return result;
    }


}
