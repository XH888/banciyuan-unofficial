package com.xh.study.bcy.ui.login;

import android.support.annotation.NonNull;

import com.xh.study.bcy.ui.base.mvp.BaseMvp;


/**
 * Created by xh on 22/04/2018.
 */

public interface LoginMvp {
    interface View extends BaseMvp.IView{
        void onEmpty();
        void onSuccessfullyLoggedIn();
    }
    interface Presenter extends BaseMvp.IPresenter{
        void login(@NonNull String username, @NonNull String password);
    }
}
