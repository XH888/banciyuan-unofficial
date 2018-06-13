package com.xh.study.bcy.bean;

import com.xh.study.bcy.bean.base.UtagsBean;

import java.util.List;

/**
 * Created by xh on 06/06/2018.
 */

public class UserBean {

        /**
         * uid : 1232985
         * uname : 易稚
         * sex : 0
         * location : 辽宁 大连市
         * self_intro : 点赞关注才有动力产粮！手动比心♡ 微博关注@-易稚
         * avatar : http://user.bcyimg.com/Public/Upload/avatar/1232985/2cbdbabc6f2b49dc8f38ac35e98cbf29/fat.jpg/abig
         * utags : [{"ut_name":"Coser"},{"ut_name":"写手"}]
         * followstate : havefollow
         * banner : http://user.bcyimg.com/Public/Upload/avatar/1232985/appbanner/c0jb9/5ea92fa7cdee465e8ee54c35867d8a7d.jpg/w650
         * is_blocked : 0
         * answer_count : 0
         * following : 8
         * follower : 10183
         * group_num : 0
         * avatar_fat : http://user.bcyimg.com/Public/Upload/avatar/1232985/2cbdbabc6f2b49dc8f38ac35e98cbf29/fat.jpg/ivs
         * value_user : false
         * verify_info :
         * ding_count : 966
         */

        private String uid;
        private String uname;
        private String sex;
        private String location;
        private String self_intro;
        private String avatar;
        private String followstate;
        private String banner;
        private int is_blocked;
        private int answer_count;
        private int following;
        private int follower;
        private String group_num;
        private String avatar_fat;
        private boolean value_user;
        private String verify_info;
        private int ding_count;
        private List<UtagsBean> utags;

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

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getSelf_intro() {
            return self_intro;
        }

        public void setSelf_intro(String self_intro) {
            this.self_intro = self_intro;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFollowstate() {
            return followstate;
        }

        public void setFollowstate(String followstate) {
            this.followstate = followstate;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public int getIs_blocked() {
            return is_blocked;
        }

        public void setIs_blocked(int is_blocked) {
            this.is_blocked = is_blocked;
        }

        public int getAnswer_count() {
            return answer_count;
        }

        public void setAnswer_count(int answer_count) {
            this.answer_count = answer_count;
        }

        public int getFollowing() {
            return following;
        }

        public void setFollowing(int following) {
            this.following = following;
        }

        public int getFollower() {
            return follower;
        }

        public void setFollower(int follower) {
            this.follower = follower;
        }

        public String getGroup_num() {
            return group_num;
        }

        public void setGroup_num(String group_num) {
            this.group_num = group_num;
        }

        public String getAvatar_fat() {
            return avatar_fat;
        }

        public void setAvatar_fat(String avatar_fat) {
            this.avatar_fat = avatar_fat;
        }

        public boolean isValue_user() {
            return value_user;
        }

        public void setValue_user(boolean value_user) {
            this.value_user = value_user;
        }

        public String getVerify_info() {
            return verify_info;
        }

        public void setVerify_info(String verify_info) {
            this.verify_info = verify_info;
        }

        public int getDing_count() {
            return ding_count;
        }

        public void setDing_count(int ding_count) {
            this.ding_count = ding_count;
        }

        public List<UtagsBean> getUtags() {
            return utags;
        }

        public void setUtags(List<UtagsBean> utags) {
            this.utags = utags;
        }
 }
