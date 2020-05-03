package cn.tedu.cloud_note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 加载笔记信息的控制层
 */
@Controller
public class LoadNoteMsgController {
    @Resource
    private NoteService service;//注入服务层

    @RequestMapping("/cloud_note/note/load.do")//匹配地址
    @ResponseBody
    public NoteResult execute(String noteId) {
        NoteResult result = service.loadNoteMsg(noteId);
        System.out.println(result);
        return result;
    }
}
