package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;

/**
 * 注册的服务层接口
 *
 * @author L
 */
public interface AddService {
    public NoteResult<Object> add(String name, String password, String nick);

}
