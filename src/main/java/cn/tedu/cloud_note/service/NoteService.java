package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.util.NoteResult;

/**
 * 笔记服务层
 *
 * @author L
 */
public interface NoteService {
    public NoteResult loadNote(String bookId);//加载笔记

    public NoteResult loadNoteMsg(String noteId);//加载笔记信息

    public NoteResult saveNote(String noteId, String title, String body);//保存笔记

    public NoteResult newNote(String bookId, String title, String userId);
}
