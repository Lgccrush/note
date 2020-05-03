package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.Note;

/**
 * 笔记持久层
 *
 * @author L
 */
public interface NoteDao {
    public List<Map> findByBookId(String bookId);//根据笔记本id查询笔记

    public Note findByNoteId(String noteId);//根据笔记id查询笔记内容

    public int updateNote(Note note);//更新笔记信息

    public int createNote(Note note);//创建笔记

}
