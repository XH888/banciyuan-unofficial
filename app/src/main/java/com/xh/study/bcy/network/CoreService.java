package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.CoreStatusBean;
import com.xh.study.bcy.bean.WeekHotWorkBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 05/05/2018.
 */

public interface CoreService {
    /**
     * 首页 - 圈子
     * data	fQq19VZM/kotWyAEV/9aMw==
     * @return
     */
    @FormUrlEncoded
    @POST("api/core/weekHotWork")
    Observable<BaseBean<List<WeekHotWorkBean>>> getWeekHotWork(@Field("data") String data);



    /**
     * circle tag head detail
     * data	YLan3B7d51Kcyv0R4XzJjAiiHGHq7OdgiL+WKkKb2QQeWgdtWuV6wuxL6UsJaGl+TseZHQ0nRQ7rzI/cRo+m5J4DPyKHLJ2JbA9pxBbfhQg=
     * @return
     */
    @FormUrlEncoded
    @POST("api/core/status")
    Observable<BaseBean<CoreStatusBean>> getStatus(@Field("data") String data);




}
