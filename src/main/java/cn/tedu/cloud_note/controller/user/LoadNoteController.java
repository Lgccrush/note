package cn.tedu.cloud_note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 笔记控制层
 *
 * @author L
 */
@Controller
public class LoadNoteController {
    @Resource
    private NoteService service;//注入服务层

    @RequestMapping("/cloud_note/note/loadnotes.do")//匹配地址
    @ResponseBody//调用json
    public NoteResult execute(String bookId) {
//		返回结果
        System.out.println(bookId);
        NoteResult result = service.loadNote(bookId);
        System.out.println(result);
        return result;
    }
}
