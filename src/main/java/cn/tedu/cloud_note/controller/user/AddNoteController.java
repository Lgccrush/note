package cn.tedu.cloud_note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
public class AddNoteController {
    @Resource
    private NoteService service;

    @RequestMapping("/cloud_note/note/add.do")
    @ResponseBody
    public NoteResult execute(String bookId, String title, String userId) {
        NoteResult result = service.newNote(bookId, title, userId);
        return result;
    }
}