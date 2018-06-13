package com.xh.study.bcy.bean;

/**
 * Created by xh on 09/06/2018.
 */

public class AskBean {

        /**
         * ua_id : 307593
         * ouid : 41517
         * cuid : 0
         * content : 请问有微博吗?
         * anonymous : 1
         * ctime : 1464689444
         * atime : 1471837001
         * answered : 1
         * answer : {"content":"http://weibo.com/yitouai","ctime":"1471837001"}
         * cuname :
         * cavatar :
         * ding_num : 5
         * have_ding : false
         */

        private String ua_id;
        private String ouid;
        private int cuid;
        private String content;
        private String anonymous;
        private String ctime;
        private long atime;
        private String answered;
        private AnswerBean answer;
        private String cuname;
        private String cavatar;
        private int ding_num;
        private boolean have_ding;

        public String getUa_id() {
            return ua_id;
        }

        public void setUa_id(String ua_id) {
            this.ua_id = ua_id;
        }

        public String getOuid() {
            return ouid;
        }

        public void setOuid(String ouid) {
            this.ouid = ouid;
        }

        public int getCuid() {
            return cuid;
        }

        public void setCuid(int cuid) {
            this.cuid = cuid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAnonymous() {
            return anonymous;
        }

        public void setAnonymous(String anonymous) {
            this.anonymous = anonymous;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public long getAtime() {
            return atime;
        }

        public void setAtime(long atime) {
            this.atime = atime;
        }

        public String getAnswered() {
            return answered;
        }

        public void setAnswered(String answered) {
            this.answered = answered;
        }

        public AnswerBean getAnswer() {
            return answer;
        }

        public void setAnswer(AnswerBean answer) {
            this.answer = answer;
        }

        public String getCuname() {
            return cuname;
        }

        public void setCuname(String cuname) {
            this.cuname = cuname;
        }

        public String getCavatar() {
            return cavatar;
        }

        public void setCavatar(String cavatar) {
            this.cavatar = cavatar;
        }

        public int getDing_num() {
            return ding_num;
        }

        public void setDing_num(int ding_num) {
            this.ding_num = ding_num;
        }

        public boolean isHave_ding() {
            return have_ding;
        }

        public void setHave_ding(boolean have_ding) {
            this.have_ding = have_ding;
        }

        public static class AnswerBean {
            /**
             * content : http://weibo.com/yitouai
             * ctime : 1471837001
             */

            private String content;
            private String ctime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }
        }
}
