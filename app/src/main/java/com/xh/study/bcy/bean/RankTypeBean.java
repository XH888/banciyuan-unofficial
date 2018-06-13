package com.xh.study.bcy.bean;

import java.util.List;

/**
 * Created by xh on 25/05/2018.
 */

public class RankTypeBean {
    /**
     * date : 20180525
     * type_set : [{"type":"lastday","name":"日榜"},{"type":"week","name":"周榜"},{"type":"newPeople","name":"新人榜"}]
     * name : 绘画榜
     * cover : https://img9.bcyimg.com/user/2660780/item/web/179i3/e77ffed05e2b11e89ac85bbdccde3ba0.jpg/2X2
     */

    private String date;
    private String name;
    private String cover;
    private List<TypeSetBean> type_set;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public List<TypeSetBean> getType_set() {
        return type_set;
    }

    public void setType_set(List<TypeSetBean> type_set) {
        this.type_set = type_set;
    }

    public static class TypeSetBean {
        /**
         * type : lastday
         * name : 日榜
         */

        private String type;
        private String name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
