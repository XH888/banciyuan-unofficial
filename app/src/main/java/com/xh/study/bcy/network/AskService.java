package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.AskBean;
import com.xh.study.bcy.bean.UserBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 06/06/2018.
 */

public interface AskService {

    /**
     * user ask detail
     * @param data
     * Saa5MPuOrGrl8z/IS3fLjiYu9g4HiT665krs+rrcmEXwkm4fTPRGbVo2PNsyne0adodUdnm0BxWN479hlEjHBw==
     * @return
     */
    @FormUrlEncoded
    @POST("api/ask/listask")
    Observable<BaseBean<List<AskBean>>> getListAsk(@Field("data") String data);

}
