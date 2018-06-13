package com.xh.study.bcy.bean;

import com.xh.study.bcy.bean.base.AffichesBean;
import com.xh.study.bcy.bean.base.PostTagsBean;

import java.util.List;

/**
 * Created by xh on 01/06/2018.
 */

public class TagStatusBean {

    /**
     * tag_id : 3590
     * name : 表情包
     * tf_status : 0
     * tf_count : 468378
     * cover : https://img9.bcyimg.com/core/tags/flag/178ki/b914ad80087711e79926ef31297fbf19.jpg/2X2
     * show_name : false
     * intro : 表情包圈子欢迎你~发布内容并打上"表情包"标签就能出现在圈子里哦~
     */

    private int tag_id;
    private String name;
    private int tf_status;
    private int tf_count;
    private String cover;
    private boolean show_name;
    private String intro;
    private List<PostTagsBean> rela;
    private List<AffichesBean> affiches;
    public List<PostTagsBean> getRela() {
        return rela;
    }

    public List<AffichesBean> getAffiches() {
        return affiches;
    }

    public void setAffiches(List<AffichesBean> affiches) {
        this.affiches = affiches;
    }

    public void setRela(List<PostTagsBean> rela) {
        this.rela = rela;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTf_status() {
        return tf_status;
    }

    public void setTf_status(int tf_status) {
        this.tf_status = tf_status;
    }

    public int getTf_count() {
        return tf_count;
    }

    public void setTf_count(int tf_count) {
        this.tf_count = tf_count;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public boolean isShow_name() {
        return show_name;
    }

    public void setShow_name(boolean show_name) {
        this.show_name = show_name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
