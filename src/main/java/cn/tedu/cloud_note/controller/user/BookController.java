package cn.tedu.cloud_note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 笔记本控制层
 *
 * @author L
 */
@Controller
public class BookController {
    @Resource
    private BookService service;//注入

    @RequestMapping("/cloud_note/book/loadBooks.do")//匹配地址
    @ResponseBody
    public NoteResult execute(String userId) {
        NoteResult result = service.loadUserBooks(userId);
        System.out.println(userId);
        System.out.println(result);
        return result;
    }
}
