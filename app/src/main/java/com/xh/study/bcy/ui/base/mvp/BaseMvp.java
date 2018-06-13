package com.xh.study.bcy.ui.base.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import net.grandcentrix.thirtyinch.TiView;
import net.grandcentrix.thirtyinch.callonmainthread.CallOnMainThread;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by xh on 22/04/2018.
 */

public interface BaseMvp {
    public interface IView extends TiView{
        @CallOnMainThread void showProgress(@StringRes int resId);
        @CallOnMainThread void hideProgress();
        @CallOnMainThread void showMessage(@NonNull String msg);

        @CallOnMainThread void showError(@NonNull String errorMsg);

        boolean isLoggedIn();

    }

    public interface IPresenter {
        void onSaveInstanceState(Bundle outState);

        void onRestoreInstanceState(Bundle outState);

        void manageDisposable(@Nullable Disposable... disposables);

        <T> void manageObservable(@Nullable Observable<T> observable);

        void manageViewDisposable(@Nullable Disposable... disposables);

        /**
         * API是否已经load
         * @return
         */
        boolean isApiCalled();

        /**
         * 在load数据前 需要做什么
         * @param cancelable
         */
        void onSubscribed(boolean cancelable);

        void onError(@NonNull Throwable throwable);

        <T> void makeRestCall(@NonNull Observable<T> observable, @NonNull Consumer<T> onNext);

        <T> void makeRestCall(@NonNull Observable<T> observable, @NonNull Consumer<T> onNext, boolean cancelable);

    }
}
