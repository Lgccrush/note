package cn.tedu.cloud_note.util;

/**
 * 自定义异常
 *
 * @author Administrator
 */
public class NoteException extends RuntimeException {
    public NoteException(String msg, Throwable t) {
        super(msg, t);
    }
}
