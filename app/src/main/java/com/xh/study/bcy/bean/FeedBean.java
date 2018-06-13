package com.xh.study.bcy.bean;

import com.xh.study.bcy.bean.base.GroupBean;
import com.xh.study.bcy.bean.base.MultiBean;
import com.xh.study.bcy.bean.base.PostTagsBean;
import com.xh.study.bcy.utils.Constant;

import java.util.List;

/**
 * Created by xh on 21/05/2018.
 */

public class FeedBean {

        /**
         * tl_type : item
         * since : 1526715621.286800
         * item_detail : {"avatar":"http://user.bcyimg.com/Public/Upload/avatar/2867565/bb05065c3a7e4edf99da31f808640b7f/fat.jpg/amiddle","ctime":1526715621,"group":{"gid":93742,"name":"为何我萌的cp如此冷？"},"item_id":"6557193664408322311","like_count":8,"multi":[],"odin_uid":"88154618310","pic_num":0,"plain":"嗯\u2026冷的话\u2026就加油产量吧少年！加油让这个cp火起来啊少年！！！","post_tags":[],"reply_count":0,"share_count":0,"type":"ganswer","uid":"2867565","uname":"败坏老七","user_liked":false}
         */

        private String tl_type;
        private String since;
        private ItemDetailBean item_detail;

        public String getTl_type() {
            return tl_type;
        }

        public void setTl_type(String tl_type) {
            this.tl_type = tl_type;
        }

        public String getSince() {
            return since;
        }

        public void setSince(String since) {
            this.since = since;
        }

        public ItemDetailBean getItem_detail() {
            return item_detail;
        }

        public void setItem_detail(ItemDetailBean item_detail) {
            this.item_detail = item_detail;
        }

        public static class ItemDetailBean {
            /**
             * avatar : http://user.bcyimg.com/Public/Upload/avatar/2867565/bb05065c3a7e4edf99da31f808640b7f/fat.jpg/amiddle
             * ctime : 1526715621
             * group : {"gid":93742,"name":"为何我萌的cp如此冷？"}
             * item_id : 6557193664408322311
             * like_count : 8
             * multi : []
             * odin_uid : 88154618310
             * pic_num : 0
             * plain : 嗯…冷的话…就加油产量吧少年！加油让这个cp火起来啊少年！！！
             * post_tags : []
             * reply_count : 0
             * share_count : 0
             * type : ganswer
             * uid : 2867565
             * uname : 败坏老七
             * user_liked : false
             */

            private String avatar;
            private long ctime;
            private GroupBean group;
            private String item_id;
            private int like_count;
            private String odin_uid;
            private int pic_num;
            private String plain;
            private int reply_count;
            private int share_count;
            private String type;
            private String uid;
            private String uname;
            private boolean user_liked;
            private List<MultiBean> multi;
            private List<PostTagsBean> post_tags;

            /**
             * article
             * content :
             * cover : https://img9.bcyimg.com/user/3073965/item/c0je2/6b4550f3f4564132bc0555c59c14a592.jpg/rc54
             * real_name : 第五人格
             * summary : 哈哈哈，各位，我回来啦。抱歉啦！
             各位，这段时间辛苦了，请见谅(･ิϖ･ิ)っ
             * title : 【杰佣】R18系列(35)
             * wid : 9233
             * word_count : 2010
             * work : 第五人格
             * work_cover : https://img9.bcyimg.com/user/3233438/item/c0je1/12c253d31b9c4a28b6cad786fca4f097.jpg/2X2
             */

            private String content;
            private String cover;
            private String real_name;
            private String summary;
            private String title;
            private int wid;
            private int word_count;
            private String work;
            private String work_cover;


            

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public long getCtime() {
                return ctime;
            }

            public void setCtime(long ctime) {
                this.ctime = ctime;
            }

            public GroupBean getGroup() {
                return group;
            }

            public void setGroup(GroupBean group) {
                this.group = group;
            }

            public String getItem_id() {
                return item_id;
            }

            public void setItem_id(String item_id) {
                this.item_id = item_id;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public String getOdin_uid() {
                return odin_uid;
            }

            public void setOdin_uid(String odin_uid) {
                this.odin_uid = odin_uid;
            }

            public int getPic_num() {
                return pic_num;
            }

            public void setPic_num(int pic_num) {
                this.pic_num = pic_num;
            }

            public String getPlain() {
                return plain;
            }

            public void setPlain(String plain) {
                this.plain = plain;
            }

            public int getReply_count() {
                return reply_count;
            }

            public void setReply_count(int reply_count) {
                this.reply_count = reply_count;
            }

            public int getShare_count() {
                return share_count;
            }

            public void setShare_count(int share_count) {
                this.share_count = share_count;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public boolean isUser_liked() {
                return user_liked;
            }

            public void setUser_liked(boolean user_liked) {
                this.user_liked = user_liked;
            }

            public List<MultiBean> getMulti() {
                return multi;
            }

            public void setMulti(List<MultiBean> multi) {
                this.multi = multi;
            }

            public List<PostTagsBean> getPost_tags() {
                return post_tags;
            }

            public void setPost_tags(List<PostTagsBean> post_tags) {
                this.post_tags = post_tags;
            }

            public int getFeedType(){
                switch (type){
                    case "article":
                        return Constant.TYPE_BEAN_ARTICLE;
                    case "note":
                        return Constant.TYPE_BEAN_NOTE;
                    case "ganswer":
                        return Constant.TYPE_BEAN_GANSWER;
                    default:
                        return Constant.TYPE_BEAN_NONE;
                }

            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }

            public int getWord_count() {
                return word_count;
            }

            public void setWord_count(int word_count) {
                this.word_count = word_count;
            }

            public String getWork() {
                return work;
            }

            public void setWork(String work) {
                this.work = work;
            }

            public String getWork_cover() {
                return work_cover;
            }

            public void setWork_cover(String work_cover) {
                this.work_cover = work_cover;
            }
        }
}
