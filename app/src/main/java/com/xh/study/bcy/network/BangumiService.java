package com.xh.study.bcy.network;

import com.xh.study.bcy.bean.BangumiBean;
import com.xh.study.bcy.bean.base.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by xh on 21/05/2018.
 */

public interface BangumiService {

    /**
     * 首页 - 新番
     * @return
     */
    @POST("api/bangumi18/getlist")
    Observable<BaseBean<List<BangumiBean>>> getList();
}
