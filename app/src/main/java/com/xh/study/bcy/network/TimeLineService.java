package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.bean.TimelineStreamBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 21/05/2018.
 */

public interface TimeLineService {

    /**
     * 首页 - 发现
     * @param data
     * @return
     */
    @FormUrlEncoded
    @POST("apiv2/timeline/stream")
    Observable<BaseBean<TimelineStreamBean>> getStream(@Field("data") String data);


    /**
     * 首页 - 关注
     * @param data
     * @return
     */
    @FormUrlEncoded
    @POST("apiv2/timeline/friendfeed")
    Observable<BaseBean<List<FeedBean>>> getFriendFeed(@Field("data") String data);


    /**
     * @param data
     * sLOvIfqbMhhQsLvuFlCplk7HmR0NJ0UO68yP3EaPpuQAJ0nag52i/ACFE2mdZOJez1oKciTXjgZTKLaiH84ZTJayU9bkGhyYP7FtTLJV1dA=
     * @return
     */
    @FormUrlEncoded
    @POST("api/timeline/getUserPostTimeline")
    Observable<BaseBean<List<FeedBean>>> getUserPostTimeline(@Field("data") String data);

}
