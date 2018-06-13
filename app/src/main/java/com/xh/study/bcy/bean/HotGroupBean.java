package com.xh.study.bcy.bean;

import com.xh.study.bcy.bean.base.PostTagsBean;

import java.util.List;

/**
 * Created by xh on 26/05/2018.
 */
public class HotGroupBean {

    /**
     * cover : https://img9.bcyimg.com/editor/flag/179i3/9cce94b05e5711e898763352f81f6184.jpg
     * code : 7#0#94922
     * intro : 【奖】JOJO为什么能被称为经典？
     * type : banner
     * gid : 94922
     * name : 【奖】JOJO的奇妙冒险为什么能被称为经典？
     * member_num : 5
     * post_num : 16
     * img_src : https://img5.bcyimg.com/group/user/484382/web/179i3/d13ceef05e5611e8895077a3b2a710cd.jpg/2X2
     * work : JOJO的奇妙冒险
     * wid : 1274
     * tags : [{"tag_name":"写作"},{"tag_name":"番剧评价"},{"tag_name":"漫评"},{"tag_name":"动画"}]
     * posts : [{"type":"ganswer","item_id":"6558705548630425859","uid":"2063240","plain":"JOJO这部漫画让我产生这样的感慨：\u201c哦，原来漫画还能这么画！\u201d它本身是一部很有创造力的作品，替身能力的开发让故事里的对抗变得新颖有趣，不会出现战斗力膨胀暴涨的局面，在战斗中，更重要的是不断思考自己的能力&hellip;"}]
     */

    private String cover;
    private String code;
    private String intro;
    private String type;
    private String gid;
    private String name;
    private int member_num;
    private int post_num;
    private String img_src;
    private String work;
    private List<PostTagsBean> tags;
    private List<PostsBean> posts;
    /**
     * gid : 92006
     * uid : 3200367
     * ptime : 1527388193
     * need_attend : false
     * id : 9233
     */

    private String uid;
    private int ptime;
    private boolean need_attend;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMember_num() {
        return member_num;
    }

    public void setMember_num(int member_num) {
        this.member_num = member_num;
    }

    public int getPost_num() {
        return post_num;
    }

    public void setPost_num(int post_num) {
        this.post_num = post_num;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public List<PostTagsBean> getTags() {
        return tags;
    }

    public void setTags(List<PostTagsBean> tags) {
        this.tags = tags;
    }

    public List<PostsBean> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsBean> posts) {
        this.posts = posts;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getPtime() {
        return ptime;
    }

    public void setPtime(int ptime) {
        this.ptime = ptime;
    }

    public boolean isNeed_attend() {
        return need_attend;
    }

    public void setNeed_attend(boolean need_attend) {
        this.need_attend = need_attend;
    }

    public static class PostsBean {
        /**
         * type : ganswer
         * item_id : 6558705548630425859
         * uid : 2063240
         * plain : JOJO这部漫画让我产生这样的感慨：“哦，原来漫画还能这么画！”它本身是一部很有创造力的作品，替身能力的开发让故事里的对抗变得新颖有趣，不会出现战斗力膨胀暴涨的局面，在战斗中，更重要的是不断思考自己的能力&hellip;
         */

        private String type;
        private String item_id;
        private String uid;
        private String plain;
        /**
         * cover : https://img5.bcyimg.com/user/2451829/item/c0je3/06b38d441ada49d5b68a72ba17b1f976.jpg/2X2
         * uname : 病名为熙-杨敬华
         * uavatar : http://user.bcyimg.com/Public/Upload/avatar/2451829/ae2ec7f475ed4f7b8a0b5c5ae24098f0/fat.jpg/amiddle
         */

        private String cover;
        private String uname;
        private String uavatar;


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPlain() {
            return plain;
        }

        public void setPlain(String plain) {
            this.plain = plain;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getUavatar() {
            return uavatar;
        }

        public void setUavatar(String uavatar) {
            this.uavatar = uavatar;
        }
    }
}
