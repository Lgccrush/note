package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Resource
    private NoteDao dao;//注入持久层

    /*加载笔记本*/
    public NoteResult loadNote(String bookId) {
        NoteResult result = new NoteResult();
        List<Map> list = dao.findByBookId(bookId);//查询笔记
        //构建结果
        result.setStatus(0);
        result.setMsg("查询笔记成功");
        result.setData(list);

        return result;
    }

    /*加载笔记*/
    public NoteResult loadNoteMsg(String noteId) {
//		构建结果集
        NoteResult result = new NoteResult();
        Note note = dao.findByNoteId(noteId);
        result.setMsg("加载笔记信息成功");
        result.setStatus(0);
        result.setData(note);
        return result;
    }

    /*保存笔记*/
    public NoteResult saveNote(String noteId, String title, String body) {
//		获取当前系统时间毫秒
        Long time = System.currentTimeMillis();
//		更新笔记信息
        Note Note = new Note();
        Note.setCn_note_body(body);
        Note.setCn_note_id(noteId);
        Note.setCn_note_title(title);
        Note.setCn_note_last_modify_time(time);
//		保存并构造结果集后返回
        NoteResult result = new NoteResult();
        if (dao.updateNote(Note) != 0) {
            result.setMsg("保存成功");
            result.setStatus(0);
            result.setData(Note);
        }
        return result;
    }

    public NoteResult newNote(String bookId, String title, String userId) {
        NoteResult result = new NoteResult();
        Note note = new Note();
        note.setCn_notebook_id(bookId);
        note.setCn_user_id(userId);
        note.setCn_note_id(NoteUtil.createId());
        note.setCn_note_body("");
        note.setCn_note_title(title);
        note.setCn_note_create_time(System.currentTimeMillis());
        note.setCn_note_last_modify_time(System.currentTimeMillis());
        note.setCn_note_type_id("1");
        note.setCn_note_status_id("1");
        int i = dao.createNote(note);
        if (i == 1) {
            result.setMsg("创建笔记成功");
            result.setStatus(0);
            result.setData(note);
        }
        return result;
    }

}
