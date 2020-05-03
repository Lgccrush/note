package cn.tedu.cloud_note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.AddService;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 注册控制层
 *
 * @author L
 */
@Controller
public class UserRegistController {
    @Resource
    private AddService service;//注入服务层

    @RequestMapping("/cloud_note/user/add.do")//匹配地址
    @ResponseBody//调用json响应
    public NoteResult execute(String name, String password, String nick) {
        NoteResult<Object> result = service.add(name, password, nick);
        System.out.println(name + "" + password + "" + nick);
        return result;
    }
}
