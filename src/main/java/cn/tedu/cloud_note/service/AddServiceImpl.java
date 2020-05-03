package cn.tedu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("addService")
public class AddServiceImpl implements AddService {
    @Resource
    private UserDao dao;//注入持久层

    public NoteResult<Object> add(String name, String password,
                                  String nick) {
        User user = dao.findByName(name);
        NoteResult<Object> result = new NoteResult<Object>();
        if (user != null) {//检查用户名是否存在
            result.setMsg("用户名已存在");
            result.setStatus(1);
            return result;
        }
//		添加用户
        User newUser = new User();
        newUser.setCn_user_id(NoteUtil.createId());//设置用户ID
        newUser.setCn_user_name(name);//设置用户名
        newUser.setCn_user_nick(nick);//设置用户昵称
        newUser.setCn_user_password(NoteUtil.md5(password));//加密用户密码
        dao.save(newUser);//存入数据库
        result.setMsg("注册成功");
        result.setStatus(0);
        return result;
    }

}
