package com.xh.study.bcy.bean;

import com.xh.study.bcy.utils.ListBeanConvert;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;

/**
 * Created by xh on 05/05/2018.
 */

@Entity
public class TypeTagCircleBean {
    /**
     * type_name : 聊番剧
     * tags_data : [{"tag_id":4668,"tag_name":"动画","tf_status":false,"cover":"https://img9.bcyimg.com/core/tags/flag/178ki/56b8a0c0086c11e7aaf1e11581d66c9a.jpg/2X2","intro":"欢迎发布新番资讯、番剧评价、动画盘点、表情包截图等内容哦~"},{"tag_id":2857,"tag_name":"漫画","tf_status":false,"cover":"https://img9.bcyimg.com/core/tags/flag/178t9/dbc41e905ca211e794c3176a52d5825b.jpg/2X2","intro":"欢迎发布漫画资讯、漫评、盘点、表情包截图等内容哦~"},{"tag_id":72,"tag_name":"小说","tf_status":false,"cover":"https://img9.bcyimg.com/core/tags/flag/178t9/eb608b805cad11e79e72c57325aaca4f.jpg/2X2","intro":"欢迎发布长评、推文等内容哦~"},{"tag_id":67,"tag_name":"游戏","tf_status":false,"cover":"https://img5.bcyimg.com/core/tags/flag/1791i/099773b0a2aa11e781acd34f1ec47bb3.jpg/2X2","intro":"欢迎发布游戏资讯、评测、攻略等内容哦~"},{"tag_id":910,"tag_name":"影视","tf_status":false,"cover":"https://img5.bcyimg.com/core/tags/flag/178kh/69331c1007e211e7a5ec699f088d375d.jpg/2X2","intro":"欢迎发布番剧评价、表情包截图等内容哦~"}]
     */
    private String type_name;
    @Convert(columnType = String.class,converter = ListBeanConvert.class)
    private List<TagsDataBean> tags_data;


    @Generated(hash = 487156718)
    public TypeTagCircleBean(String type_name, List<TagsDataBean> tags_data) {
        this.type_name = type_name;
        this.tags_data = tags_data;
    }

    @Generated(hash = 1536815177)
    public TypeTagCircleBean() {
    }


    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public List<TagsDataBean> getTags_data() {
        return tags_data;
    }

    public void setTags_data(List<TagsDataBean> tags_data) {
        this.tags_data = tags_data;
    }

    @Entity
    public static class TagsDataBean {
        /**
         * tag_id : 4668
         * tag_name : 动画
         * tf_status : false
         * cover : https://img9.bcyimg.com/core/tags/flag/178ki/56b8a0c0086c11e7aaf1e11581d66c9a.jpg/2X2
         * intro : 欢迎发布新番资讯、番剧评价、动画盘点、表情包截图等内容哦~
         */

        private int tag_id;
        private String tag_name;
        private boolean tf_status;
        private String cover;
        private String intro;

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

        public boolean isTf_status() {
            return tf_status;
        }

        public void setTf_status(boolean tf_status) {
            this.tf_status = tf_status;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }
    }
}
