package com.xh.study.bcy.bean.base;


/**
 * Created by xh on 21/05/2018.
 */

public class PostTagsBean {
    /**
     * cover : https://img5.bcyimg.com/core/tags/flag/178kh/69331c1007e211e7a5ec699f088d375d.jpg/2X2
     * tag_id : 910
     * tag_name : 影视
     * type : tag
     */

    private String cover;
    private int tag_id;
    private String tag_name;
    private String type;
    private String intro;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}