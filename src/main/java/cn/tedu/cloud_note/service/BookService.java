package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 笔记本服务层
 *
 * @author L
 */
public interface BookService {
    //	加载笔记本
    public NoteResult loadUserBooks(String userId);

    //	创建笔记本
    public NoteResult addBook(String userId, String bookName);
}
