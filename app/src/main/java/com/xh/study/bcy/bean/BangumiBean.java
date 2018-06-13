package com.xh.study.bcy.bean;

import com.xh.study.bcy.bean.base.EpisodeBean;

import java.util.List;

/**
 * Created by xh on 24/05/2018.
 */

public class BangumiBean {
    /**
     * type_name : 次元娘推番指南
     * type_id : 1
     * data : [{"id":1000,"name":"银河英雄传说 全新命....}]}]
     */

    private String type_name;
    private int type_id;
    private List<DataBean> data;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1000
         * name : 银河英雄传说 全新命题
         * cover : https://img9.bcyimg.com//editor/flag/179cm/3369645030bc11e897dea9be0cf0da32.png
         * wid : 3565
         * intro : 半次元全网独播   每周二 20:30 更新<br>在宇宙历8世纪末，两位天才的登场推动了历史的巨轮：<br>“战争天才”莱因哈特·冯·罗严克拉姆，以及人称“黑发魔术师”的杨威利。<br>两人率领帝国军与同盟军，一再展开激烈的对决。<br>声优列表<br>莱因哈特·冯·罗严克拉姆：宫野真守<br>杨威利：铃村健一<br>齐格飞·吉尔菲艾斯：梅原裕一郎<br>尤里安·敏兹：梶裕贵<br>巴尔·冯·奥贝斯坦：诹访部顺一<br>渥佛根·米达麦亚：小野大辅<br>奥斯卡·冯·罗严塔尔：中村悠一<br>亚列克斯·卡介伦：川岛得爱<br>菲列特利加·格林希尔：远藤绫<br>华尔特·冯·先寇布：三木真一郎
         * share_url : https://bcy.net/bangumi/list/1000
         * episode : [{"index_name":"01","vid":"7856f6e31cc94d29a9a9d4be6547427b"},{"index_name":"02","vid":"d2899c15cceb456e995d370a61f8e898"},{"index_name":"03","vid":"3ceb8467132a455f8e87c375c123ec2f"},{"index_name":"04","vid":"c7e78a40da77415eac3c9bd09a166604"},{"index_name":"05","vid":"v02041b30000bbk2j7i6tgqcb4rplnfg"},{"index_name":"06","vid":"v020418d0000bbom9e8697arv6g1mt2g"},{"index_name":"07","vid":"v020416f0000bbt9qt7a1havlru7ht20"},{"index_name":"08","vid":"v02041e30000bc2jg7mlg9jora0bqro0"},{"index_name":"PV","vid":"8853a4c194c04fd18bc167067b1509a4"},{"index_name":"PV2","vid":"8a1f7eb2d27e4ae4a049642ea9552a9c"}]
         */

        private int id;
        private String name;
        private String cover;
        private int wid;
        private String intro;
        private String share_url;
        private List<EpisodeBean> episode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public List<EpisodeBean> getEpisode() {
            return episode;
        }

        public void setEpisode(List<EpisodeBean> episode) {
            this.episode = episode;
        }
    }
}
