package com.xh.study.bcy.bean;

import com.xh.study.bcy.bean.base.AffichesBean;
import com.xh.study.bcy.bean.base.GroupBean;
import com.xh.study.bcy.bean.base.PostTagsBean;

import java.util.List;

/**
 * Created by xh on 25/05/2018.
 */

public class RelaPropsBean {

    /**
     * tag_id : 5798
     * affiches : [{"text":"【本期国人绘师推荐】果酱子777，色彩超好看哒！","link":"8#0#aHR0cHM6Ly9iY3kubmV0L3NwZWNpYWwvZGV0YWlsLzg2NA=="},{"text":"测一测，今天适合你画的本命姿♂势PLAY是？","link":"8#0#aHR0cHM6Ly9oNS5iYW5jaXl1YW4ubWUvMjAxNy90ZXN0cGxheS8="},{"text":"CP股市行情！热度走势一览！你入股了吗？","link":"8#0#aHR0cHM6Ly9iY3kubmV0L2Nwc3RvY2s="}]
     * rela : [{"type":"tag","tag_name":"绘画教程","tag_id":"14483","cover":"https://img9.bcyimg.com/core/tags/flag/1789d/8196d300796211e6a6a4bbfe308b290c.jpg/2X2","intro":"绘画教程圈子欢迎你~发布内容并打上\"绘画教程\"标签就能出现在圈子里哦~"},{"type":"tag","tag_name":"手绘","tag_id":"1124","cover":"https://img9.bcyimg.com/core/work/flag/bzwp4/962493a088f611e5b6edcf530cda0df0.jpg/2X2","intro":"手绘圈子欢迎你~发布内容并打上\"手绘\"标签就能出现在圈子里哦~"},{"type":"tag","tag_name":"本宣","tag_id":"8105","cover":"https://img5.bcyimg.com/core/tags/flag/c04ch/da4e1a509a5811e6bb5af17cd9e0ef04.jpg/2X2","intro":"站内发布本宣+微博本宣@半次元绘画频道，可获得站内绘画娘推荐+微博双重帮扩哦！"},{"type":"tag","tag_name":"求约稿","tag_id":"29501","cover":"https://img5.bcyimg.com/core/tags/flag/1789d/8c8ee630796211e68772abb666a6cf0b.jpg/2X2","intro":"求约稿建议注明：稿费+擅长的风格(附图)+接稿喜好(优先/不接)+其他"},{"type":"tag","tag_name":"古风","tag_id":"15","cover":"https://img5.bcyimg.com/core/tags/flag/178ki/250a6e90088611e79cd2af395e9b927b.png/2X2","intro":"古风圈子欢迎你~发布内容并打上\"古风\"标签就能出现在圈子里哦~"},{"type":"tag","tag_name":"欧美","tag_id":"3125","cover":"https://img5.bcyimg.com/core/tags/flag/178ki/6cf70f60088611e7820effb593f46365.png/2X2","intro":"发布内容并打上\"欧美\"标签就能出现在圈子里哦~"},{"type":"tag","tag_name":"故事漫画","tag_id":"136952","cover":"https://img5.bcyimg.com/core/tags/flag/178ki/660ec8d0086a11e7a3c8c3885c23f7d2.jpg/2X2","intro":"欢迎发布分镜漫画、条漫、四格~打上\"故事漫画\"标签就能出现在本圈啦~"},{"type":"tag","tag_name":"BL","tag_id":"17","cover":"https://img5.bcyimg.com/core/work/flag/bzwp4/2c921e5088e511e5aab39154313b7c14.jpg/2X2","intro":"BL圈子欢迎你~发布内容并打上\"BL\"标签就能出现在圈子里哦~"},{"type":"tag","tag_name":"GL","tag_id":"8984","cover":"https://img5.bcyimg.com/core/tags/flag/1789d/d3ab0d10796111e6addde376cc2c5844.jpg/2X2","intro":"GL圈子欢迎你~发布内容并打上\"GL\"标签就能出现在圈子里哦~"}]
     * groups : [{"gid":94189,"name":"如何画眼神？有哪些技巧？"},{"gid":88478,"name":"各位写手画师coser敢放一下自己的粉丝关注截屏吗？"},{"gid":77506,"name":"我们是根据什么来判断动漫角色的身份？"}]
     */

    private int tag_id;
    private List<AffichesBean> affiches;
    private List<PostTagsBean> rela;
    private List<GroupBean> groups;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public List<AffichesBean> getAffiches() {
        return affiches;
    }

    public void setAffiches(List<AffichesBean> affiches) {
        this.affiches = affiches;
    }

    public List<PostTagsBean> getRela() {
        return rela;
    }

    public void setRela(List<PostTagsBean> rela) {
        this.rela = rela;
    }

    public List<GroupBean> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupBean> groups) {
        this.groups = groups;
    }




}
