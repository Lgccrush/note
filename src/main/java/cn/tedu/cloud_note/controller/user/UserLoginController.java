package cn.tedu.cloud_note.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 用户类的控制层
 *
 * @author L
 */
@Controller
public class UserLoginController {
    @Resource
    private UserService userService;

    @RequestMapping("/cloud_note/user/login.do")
    @ResponseBody //调用json
    public NoteResult<User> execute(String name, String password) {
        /*
         * 调用UserService处理登录
         */
        System.out.println(name + ":" + password);
        NoteResult result = userService.checkLogin(name, password);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/cloud_note/logout.do")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();

        return "redirect:/log_in.html  ";
    }
}
