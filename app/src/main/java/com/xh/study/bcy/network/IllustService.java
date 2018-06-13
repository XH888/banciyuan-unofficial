package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.BannerBean;
import com.xh.study.bcy.bean.RankTypeBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 05/05/2018.
 */

public interface IllustService {

    /**
     * 频道 - 绘画  banner
     * data JJiBgkck9BO7UuTB4HKVZPfS5q7hO3NeGYWNMP4JAgg=
     * @return
     */
    @FormUrlEncoded
    @POST("api/illust/banners")
    Observable<BaseBean<List<BannerBean>>> getBanners(@Field("data") String data);

    /**
     * 频道 - 绘画  banner2 中的第一个元素
     * data	JJiBgkck9BO7UuTB4HKVZPfS5q7hO3NeGYWNMP4JAgg=
     * @return
     */
    @FormUrlEncoded
    @POST("api/illust/rankTypes")
    Observable<BaseBean<RankTypeBean>> getRankTypes(@Field("data") String data);

}
