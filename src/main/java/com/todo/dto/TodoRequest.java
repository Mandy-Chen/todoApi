package com.todo.dto;

import java.util.Date;

public class TodoRequest {
    private Integer id;
    private String content;
    private Boolean status;
    private Date createTime;

    public TodoRequest(Integer id, String content, Boolean status, Date createTime) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
