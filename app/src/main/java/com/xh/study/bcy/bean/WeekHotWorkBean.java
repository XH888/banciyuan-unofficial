package com.xh.study.bcy.bean;

/**
 * Created by xh on 05/05/2018.
 */

public class WeekHotWorkBean {

    /**
     * id : 6332
     * real_name : 凹凸世界
     * cover : https://img5.bcyimg.com/core/work/flag/1791b/e68283109ceb11e7876739e6c6b80f9c.jpg/2X2
     * post_count : 4701
     * wf_status : false
     */

    private int id;
    private String real_name;
    private String cover;
    private int post_count;
    private boolean wf_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getPost_count() {
        return post_count;
    }

        public void setPost_count(int post_count) {
            this.post_count = post_count;
        }

        public boolean isWf_status() {
            return wf_status;
        }

        public void setWf_status(boolean wf_status) {
            this.wf_status = wf_status;
        }

        public boolean getWf_status() {
            return this.wf_status;
        }
}
