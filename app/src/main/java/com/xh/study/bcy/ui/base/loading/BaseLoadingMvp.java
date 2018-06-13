package com.xh.study.bcy.ui.base.loading;

import android.support.annotation.NonNull;

import com.xh.study.bcy.ui.base.mvp.BaseMvp;
import com.xh.study.bcy.utils.Constant;


import java.util.List;

/**
 * Created by xh on 29/04/2018.
 * Loading模块
 * View有三个动作(LOAD、LOAD_MORE、REFRESH)。
 * Present负责读取网络数据，通知View改变操作。
 */

public interface BaseLoadingMvp {
    interface View extends BaseMvp.IView {
        /**
         * 第一次载入 或者 错误后手动载入
         * @param items
         */
        void loadData(@NonNull List  items);

        /**
         * 载入更多数据
         * @param items
         */
        void loadMore(@NonNull List  items);

        /**
         * 拉取最新数据
         * @param items
         */
        void refreshNew(@NonNull List items);

    }

    interface Presenter extends BaseMvp.IPresenter{
        /**
         * 读取网络数据给View
         * @param loadType 由于原API formData加密了。这里做参数模拟操作(LOAD、LOAD_MORE、REFRESH)
         */
        void loadData(@Constant.LoadType int loadType);

        /**
         * 存放整个View的Item list
         * @return
         */
        List<?> getItems();
    }
}
