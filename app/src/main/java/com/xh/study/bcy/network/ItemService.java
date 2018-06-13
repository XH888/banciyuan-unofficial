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

public interface ItemService {

    /**
     * 首页 - 关注 Item详细
     * dataJJiBgkck9BO7UuTB4HKVZDikLSlUbkZx0YNC0tviismMXXrSbpjuUBZ2K2YEemwU0TaUfHblUNrV+HyZG2KFFw==
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("apiv2/timeline/stream")
    Observable<BaseBean<TimelineStreamBean>> getDetail(@Field("data") String data);


    /**
     * 首页 - 关注 Item详细 下面的回复内容List
     * Y2MqGy1oCktlgmNB56198QGhV2DEHMdjJTlzBoE0XhstD9Qx6uMAHDePfKlFLMgn0AjPf0UQfcazVzZk0HjPgqFB3tk7FQEO66pcyy9BMpc=
     * @param data
     * @return
     */
    @FormUrlEncoded
    @POST("apiv2/timeline/friendfeed")
    Observable<BaseBean<List<FeedBean>>> getReplay(@Field("data") String data);

}
