package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.RelaPropsBean;
import com.xh.study.bcy.bean.TagStatusBean;
import com.xh.study.bcy.bean.TypeTagCircleBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 05/05/2018.
 */

public interface TagService {

    /**
     * 首页 - 圈子
     * data fQq19VZM/kotWyAEV/9aMw==
     * @return
     */
    @FormUrlEncoded
    @POST("api/tag/typeTagCircle")
    Observable<BaseBean<List<TypeTagCircleBean>>> getTypeTagCircle(@Field("data") String data);

    /**
     * 发现 - 上面的Search提示数据
     * data	BK83kEWqeoHaP+xIuIm1AA==
     * @return
     */
    @FormUrlEncoded
    @POST("api/tag/searchTags")
    Observable<BaseBean<List<String>>> getSearchTags(@Field("data") String data);

    /**
     * 发现 - 绘画 头部的第二层详细信息
     * data	CK1T7PY/GkVY7ZiWjxAIFspXmIYKG3IfPDhdOqQoYmT30uau4TtzXhmFjTD+CQII
     * @return
     */
    @FormUrlEncoded
    @POST("api/tag/relaProps")
    Observable<BaseBean<RelaPropsBean>> getRelaProps(@Field("data") String data);


    /**
     * Item tag detail head
     * tag:表情包  MwNwvlO9Y90+3d77yymjoLnIE/XdUzG+tHevh6QNLvCbWf/bX9z/yhtPT/Umyi7e
     * tag:白丝   JhYFr1yL9qHHRbVGzDv9T8pXmIYKG3IfPDhdOqQoYmT30uau4TtzXhmFjTD+CQII
     * @return
     */
    @FormUrlEncoded
    @POST("api/tag/status")
    Observable<BaseBean<TagStatusBean>> getTagStatus(@Field("data") String data);



}
