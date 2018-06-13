package com.xh.study.bcy.ui.main;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.xh.study.bcy.ui.base.mvp.BaseMvp;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xh on 25/04/2018.
 */

public interface MainMvp {
    int MAINPAGE = 0;
    int DISCOVER = 1;
    int POST = 2;
    int GROUP = 3;
    int MINE = 4;

    @IntDef({
            MAINPAGE,
            DISCOVER,
            POST,
            GROUP,
            MINE
    })
    @Retention(RetentionPolicy.SOURCE) @interface NavigationType {}

    interface View extends BaseMvp.IView{
        /**
         * 点击主页导航
         * @param type
         */
        void onNavigationChanged(@NavigationType int type);
//
//        /**
//         *  主页导航Reselect
//         */
//        void onNavigationReselected(BaseLoadingFragment fragment);
    }

    interface Presenter extends BaseMvp.IPresenter {
        /**
         * 用于显示隐藏当前和需要显示的Fragment
         * @param fragmentManager
         * @param toShow 需要显示的
         * @param toHide 需要隐藏的
         */
        void onShowHideFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment toShow, @NonNull Fragment toHide);

        /**
         * 用于创建和隐藏
         * @param fragmentManager
         * @param toAdd
         * @param toHide
         */
        void onAddAndHide(@NonNull FragmentManager fragmentManager, @NonNull Fragment toAdd, @NonNull Fragment toHide);
        /**
         * 显示根据导航ID 显示 主页哪个Fragment
         * @param fragmentManager
         * @param type
         */
        void onModuleChanged(@NonNull FragmentManager fragmentManager, @MainMvp.NavigationType int type);
    }

}
