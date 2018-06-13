package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.UserBean;
import com.xh.study.bcy.bean.base.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 06/06/2018.
 */

public interface UserService {

    /**
     * user smooth layout
     * @param data
     * JJiBgkck9BO7UuTB4HKVZGz0phG2rFH7oNir1mTu4iIM4bjXIsfvFLG+m9mKDcK43DmqO35SciZpjpFOI5HDww==
     * @return
     */
    @FormUrlEncoded
    @POST("api/user/detail")
    Observable<BaseBean<UserBean>> getUserDetail(@Field("data") String data);

}
