package cn.tedu.cloud_note.util;

import java.io.Serializable;

/**
 * 用于接收返回结果的类
 *
 * @author L
 */
public class NoteResult<T> implements Serializable {
    private int status;//状态
    private String msg;//提示消息
    private T data;//返回类型(不知道具体类型用泛型)

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NoteResult [status=" + status + ", msg=" + msg + ", data="
                + data + "]";
    }

}
