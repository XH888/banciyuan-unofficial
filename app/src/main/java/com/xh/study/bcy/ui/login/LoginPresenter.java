package com.xh.study.bcy.ui.login;


import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by xh on 04/02/2018.
 */

public class LoginPresenter extends BasePresenter<LoginMvp.View> implements LoginMvp.Presenter {

    /**
     * 模拟登陆
     * @return
     */
    @Override
    public void login(@NonNull String username, @NonNull String password ){
        if(getView()==null) return;
        if (TextUtils.isEmpty(password) || TextUtils.isEmpty(username)) {
            getView().onEmpty();
        }else {
            makeRestCall(
                    Observable.timer(2, TimeUnit.SECONDS),l->{
                        getView().onSuccessfullyLoggedIn();
                    }
            );
        }
    }

}
