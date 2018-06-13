package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 21/05/2018.
 */

public interface CircleService {

    /**
     * 发现 - 绘画 主要的List
     * data UMjdMOTXvayQwBiiq/niPkd1mppVp3+lmyJiZgoYPqCa6jJDJgm253hZdRJO77tJqIh74/scW2sqMokNhiZUrnlnZj36bIRnW+S3xU/d2wo=
     *
     */
    @FormUrlEncoded
    @POST("api/circle/itemHotTags")
    Observable<BaseBean<List<FeedBean>>> getItemHotTags(@Field("data") String data);

    /**
     * circle tag list detail
     * @param data fbFRQFahzpOC8aX82rebMoepCN/ZBI75OzlPV6P41noLyfUkIesPZ7MBnJvyAbnXmuoyQyYJtud4WXUSTu+7Schz+f6itkAK1q5suicgPlQ=
     * @return
     */
    @FormUrlEncoded
    @POST("api/circle/itemHotWorks")
    Observable<List<FeedBean>> getItemHotWorks(@Field("data") String data);

}
