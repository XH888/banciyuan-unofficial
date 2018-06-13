package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.HotGroupBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xh on 05/05/2018.
 */

public interface GroupService {

    /**
     * 问答 - 热门1
     * @return
     */
    @POST("api/group/hotGroupContent")
    Observable<BaseBean<List<HotGroupBean>>> getHotGroupContent( );

    /**
     * 问答 - 热门2
     * data QMbWyb1x5jOqfKyrmrSTgdAIz39FEH3Gs1c2ZNB4z4KhQd7ZOxUBDuuqXMsvQTKX
     * @return
     */
    @FormUrlEncoded
    @POST("api/group/HotAttend")
    Observable<BaseBean<List<HotGroupBean>>> getHotAttend(@Field("data") String data);

    /**
     * 问答 - ACG
     * data IUrJSKvkdS47TB7OgHebNfuIrwYIYDJYj2lRWTu4q8M=
     * @return
     */
    @FormUrlEncoded
    @POST("api/group/listHotTag")
    Observable<BaseBean<List<HotGroupBean>>> getListHotTag(@Field("data") String data);
}
