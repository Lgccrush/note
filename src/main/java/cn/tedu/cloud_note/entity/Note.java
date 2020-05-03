package cn.tedu.cloud_note.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 笔记本类
 *
 * @author L
 */
public class Note implements Serializable {
    private String cn_user_id;//用户id
    private String cn_notebook_id;//笔记本id
    private String cn_note_id;//笔记id
    private String cn_note_status_id;//笔记状态id
    private String cn_note_type_id;//笔记类型id
    private String cn_note_title;//笔记标题
    private String cn_note_body;//笔记类型
    private Long cn_note_create_time;//笔记创建时间
    private Long cn_note_last_modify_time;//笔记最近修改时间

    public String getCn_user_id() {
        return cn_user_id;
    }

    public void setCn_user_id(String cn_user_id) {
        this.cn_user_id = cn_user_id;
    }

    public String getCn_notebook_id() {
        return cn_notebook_id;
    }

    public void setCn_notebook_id(String cn_notebook_id) {
        this.cn_notebook_id = cn_notebook_id;
    }

    public String getCn_note_id() {
        return cn_note_id;
    }

    public void setCn_note_id(String cn_note_id) {
        this.cn_note_id = cn_note_id;
    }

    public String getCn_note_status_id() {
        return cn_note_status_id;
    }

    public void setCn_note_status_id(String cn_note_status_id) {
        this.cn_note_status_id = cn_note_status_id;
    }

    public String getCn_note_type_id() {
        return cn_note_type_id;
    }

    public void setCn_note_type_id(String cn_note_type_id) {
        this.cn_note_type_id = cn_note_type_id;
    }

    public String getCn_note_title() {
        return cn_note_title;
    }

    public void setCn_note_title(String cn_note_title) {
        this.cn_note_title = cn_note_title;
    }

    public String getCn_note_body() {
        return cn_note_body;
    }

    public void setCn_note_body(String cn_note_body) {
        this.cn_note_body = cn_note_body;
    }

    public Long getCn_note_create_time() {
        return cn_note_create_time;
    }

    public void setCn_note_create_time(Long cn_note_create_time) {
        this.cn_note_create_time = cn_note_create_time;
    }

    public Long getCn_note_last_modify_time() {
        return cn_note_last_modify_time;
    }

    public void setCn_note_last_modify_time(Long cn_note_last_modify_time) {
        this.cn_note_last_modify_time = cn_note_last_modify_time;
    }

    @Override
    public String toString() {
        return "Note [cn_user_id=" + cn_user_id + ", cn_notebook_id="
                + cn_notebook_id + ", cn_note_id=" + cn_note_id
                + ", cn_note_status_id=" + cn_note_status_id
                + ", cn_note_type_id=" + cn_note_type_id + ", cn_note_title="
                + cn_note_title + ", cn_note_body=" + cn_note_body
                + ", cn_note_create_time=" + cn_note_create_time
                + ", cn_note_modify_time=" + cn_note_last_modify_time + "]";
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

}
