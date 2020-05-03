package cn.tedu.cloud_note.dao;

import java.util.List;

import cn.tedu.cloud_note.entity.Book;

/**
 * 笔记本类的持久层
 *
 * @author L
 */
public interface BookDao {
    //	通过用户id查询出对应的book
    public List<Book> findByUserId(String id);

    public int createBook(Book book);
}
