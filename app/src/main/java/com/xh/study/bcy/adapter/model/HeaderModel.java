package com.xh.study.bcy.adapter.model;

import com.xh.study.bcy.bean.BannerBean;
import com.xh.study.bcy.bean.RankTypeBean;
import com.xh.study.bcy.bean.RelaPropsBean;
import com.xh.study.bcy.bean.base.PostTagsBean;

import java.util.List;

/**
 * Created by xh on 14/05/2018.
 * 里面设置常见的头部数据，一般都是保存在数据库中。或者网络读取方便读取
 */

public class HeaderModel {
    //discover
    private List<BannerBean> banners;
    private RankTypeBean rankTypeBean;
    private List< PostTagsBean> relas;


    //单行多行 flag
    private boolean isSingle;


    public boolean isSingle() {
        return isSingle;
    }

    public void setSingle(boolean single) {
        isSingle = single;
    }

    public RankTypeBean getRankTypeBean() {
        return rankTypeBean;
    }

    public void setRankTypeBean(RankTypeBean rankTypeBean) {
        this.rankTypeBean = rankTypeBean;
    }

    public List<BannerBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerBean> banners) {
        this.banners = banners;
    }

    public List<PostTagsBean> getRelas() {
        return relas;
    }

    public void setRelas(List<PostTagsBean> relas) {
        this.relas = relas;
    }
}
