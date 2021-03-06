package com.gutongxue.wxapp.domain;

import com.gutongxue.wxapp.util.GRQUtil;

public class LogDO {
    private int id;
    private String time;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if (!GRQUtil.checkNull(time)){
            time=time.split("\\.")[0];
        }
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
