package cn.tedu.cloud_note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 保存笔记的控制层
 *
 * @author L
 */
@Controller
public class UpdateNoteController {
    @Resource
    private NoteService service;

    @RequestMapping("/cloud_note/note/update.do")
    @ResponseBody
    public NoteResult execute(String noteId, String title, String body) {
        NoteResult result = service.saveNote(noteId, title, body);
        System.out.println(result.getMsg());
        System.out.println(result);
        return result;
    }
}
