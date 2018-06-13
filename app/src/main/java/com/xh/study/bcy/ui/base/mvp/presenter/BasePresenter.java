package com.xh.study.bcy.ui.base.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.state.StateSaver;
import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.mvp.BaseMvp;
import com.xh.study.bcy.utils.RxHelper;

import net.grandcentrix.thirtyinch.TiPresenter;
import net.grandcentrix.thirtyinch.rx2.RxTiPresenterDisposableHandler;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;

/**
 * Created by xh on 22/04/2018.
 */

public class BasePresenter<V extends BaseMvp.IView> extends TiPresenter<V> implements BaseMvp.IPresenter{

    private boolean apiCalled;
    private final RxTiPresenterDisposableHandler subscriptionHandler = new RxTiPresenterDisposableHandler(this);

    @Override
    public void onSaveInstanceState(Bundle outState) {
        StateSaver.saveInstanceState(this,outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle outState) {
        if(outState!=null)
            StateSaver.restoreInstanceState(this,outState);
    }

    @Override
    public void manageDisposable(@Nullable Disposable... disposables) {
        if(disposables!=null)
            subscriptionHandler.manageDisposables(disposables);
    }

    @Override
    public <T> void manageObservable(@Nullable Observable<T> observable) {
        if(observable!=null)
            manageDisposable(RxHelper.getObservable(observable).subscribe(t -> {},Throwable::printStackTrace));
    }

    @Override
    public void manageViewDisposable(@Nullable Disposable... disposables) {
        if (disposables != null) {
            if (isViewAttached()) {
                subscriptionHandler.manageViewDisposables(disposables);
            } else {
                sendToView(v -> manageViewDisposable(disposables));
            }
        }
    }

    @Override
    public boolean isApiCalled() {
        return apiCalled;
    }

    @Override
    public void onSubscribed(boolean cancelable) {
        sendToView(v ->
            v.showProgress(R.string.loading)
        );
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        apiCalled = true;
        //throwable.printStackTrace();

        sendToView(v -> v.showError(getFormatErrorMessage(throwable)));

    }

    private String getFormatErrorMessage(@Nullable Throwable throwable) {
        String msg = throwable.getMessage();
        if (throwable instanceof HttpException) {
            msg = "HttpException";
        } else if (throwable instanceof IOException) {
            msg = "IOException";
        } else if (throwable instanceof TimeoutException) {
            msg = "TimeoutException";
        }
        return msg;
    }

    @Override
    public <T> void makeRestCall(@NonNull Observable<T> observable, @NonNull Consumer<T> onNext) {
        makeRestCall(observable, onNext, true);
    }

    @Override
    public <T> void makeRestCall(@NonNull Observable<T> observable, @NonNull Consumer<T> onNext, boolean cancelable) {
        manageDisposable(
                RxHelper.getObservable(observable)
                        .doOnSubscribe(disposable -> onSubscribed(cancelable))
                        .subscribe(onNext, this::onError, () -> apiCalled = true)
        );
    }
}
