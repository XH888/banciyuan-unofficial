package com.xh.study.bcy.bean;

import com.xh.study.bcy.bean.base.UtagsBean;

import java.util.List;

/**
 * Created by xh on 26/05/2018.
 */

public class ReplayBean {

        /**
         * uid : 865871
         * ctime : 1527288723
         * content : 抱走当宠物饲养(。・∀・)ノ゛
         * id : 6559655119560900868
         * like_count : 0
         * comments : [{"id":"6559720399876129038","uid":"865871","content":"回复 @易稚 : 摸头摸头( ´･･)ﾉ(._.`)","ctime":1527303922,"like_count":0,"uname":"少司书长","avatar":"http://user.bcyimg.com/Public/Upload/avatar/865871/df32e55c2a974654a576e35689cdeabc/fat.jpg/amiddle"},{"id":"6559694962236064014","uid":"1232985","content":"(!⊙ω⊙)ノ","ctime":1527298000,"like_count":0,"uname":"易稚","avatar":"http://user.bcyimg.com/Public/Upload/avatar/1232985/2cbdbabc6f2b49dc8f38ac35e98cbf29/fat.jpg/amiddle"}]
         * comments_count : 2
         * at_users : []
         * user_liked : false
         * uname : 少司书长
         * avatar : http://user.bcyimg.com/Public/Upload/avatar/865871/df32e55c2a974654a576e35689cdeabc/fat.jpg/abig
         * utags : [{"ut_name":"写手"},{"ut_name":"绘师"}]
         * is_end : true
         */

        private String uid;
        private int ctime;
        private String content;
        private String id;
        private int like_count;
        private int comments_count;
        private boolean user_liked;
        private String uname;
        private String avatar;
        private boolean is_end;
        private List<CommentsBean> comments;
        private List<?> at_users;
        private List<UtagsBean> utags;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isUser_liked() {
            return user_liked;
        }

        public void setUser_liked(boolean user_liked) {
            this.user_liked = user_liked;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public boolean isIs_end() {
            return is_end;
        }

        public void setIs_end(boolean is_end) {
            this.is_end = is_end;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public List<?> getAt_users() {
            return at_users;
        }

        public void setAt_users(List<?> at_users) {
            this.at_users = at_users;
        }

        public List<UtagsBean> getUtags() {
            return utags;
        }

        public void setUtags(List<UtagsBean> utags) {
            this.utags = utags;
        }

        public static class CommentsBean {
            /**
             * id : 6559720399876129038
             * uid : 865871
             * content : 回复 @易稚 : 摸头摸头( ´･･)ﾉ(._.`)
             * ctime : 1527303922
             * like_count : 0
             * uname : 少司书长
             * avatar : http://user.bcyimg.com/Public/Upload/avatar/865871/df32e55c2a974654a576e35689cdeabc/fat.jpg/amiddle
             */

            private String id;
            private String uid;
            private String content;
            private int ctime;
            private int like_count;
            private String uname;
            private String avatar;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCtime() {
                return ctime;
            }

            public void setCtime(int ctime) {
                this.ctime = ctime;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }


}
