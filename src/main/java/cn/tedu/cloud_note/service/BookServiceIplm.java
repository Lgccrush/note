package cn.tedu.cloud_note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("bookService")
public class BookServiceIplm implements BookService {
    @Resource
    private BookDao dao;//注入持久层

    public NoteResult loadUserBooks(String userId) {
        List<Book> list = dao.findByUserId(userId);
//		构建返回结果
        NoteResult result = new NoteResult();
        if (list.toString() == "[]") {
            result.setStatus(1);
            result.setMsg("没有笔记");
            return result;
        } else {
            result.setStatus(0);
            result.setMsg("所有笔记如下");
            result.setData(list);
            return result;
        }
    }

    public NoteResult addBook(String userId, String bookName) {
        NoteResult result = new NoteResult();
        Book book = new Book();
        book.setCn_notebook_name(bookName);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        book.setCn_notebook_createtime(d);
        book.setCn_notebook_desc("");
        book.setCn_notebook_id(NoteUtil.createId());
        book.setCn_notebook_type_id("1");
        book.setCn_user_id(userId);
        int i = dao.createBook(book);
        if (i == 1) {
            result.setMsg("创建笔记本成功");
            result.setData(book);
            result.setStatus(0);
        }
        return result;
    }
}
