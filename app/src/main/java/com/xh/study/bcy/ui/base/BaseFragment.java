package com.xh.study.bcy.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evernote.android.state.StateSaver;
import com.xh.study.bcy.ui.base.mvp.BaseMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;

import net.grandcentrix.thirtyinch.TiFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xh on 08/02/2018.
 */

public abstract class BaseFragment<V extends BaseMvp.IView, P extends BasePresenter<V>> extends TiFragment<P, V> implements BaseMvp.IView {

    protected BaseMvp.IView callback;
    @Nullable private Unbinder unbinder;
    protected View rootView ;

    @LayoutRes
    protected abstract int fragmentLayout();

    protected abstract void onFragmentCreated(@NonNull View view, @Nullable Bundle savedInstanceState);

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseMvp.IView) {
            callback = (BaseMvp.IView) context;
        }
    }

    @Override public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        StateSaver.saveInstanceState(this, outState);
        getPresenter().onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null && !savedInstanceState.isEmpty()) {
            StateSaver.restoreInstanceState(this, savedInstanceState);
            getPresenter().onRestoreInstanceState(savedInstanceState);
        }
        Log.w(getClass().getName() ,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (fragmentLayout() != 0) {
            rootView = LayoutInflater.from(getContext()).inflate( fragmentLayout(), container, false);
            unbinder = ButterKnife.bind(this, rootView);
            return rootView;
        }
        Log.w(getClass().getName(),"onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onFragmentCreated(view, savedInstanceState);
        Log.w(getClass().getName(),"onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w(getClass().getName(),"onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) unbinder.unbind();
        Log.w(getClass().getName(),"onDestroyView");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w(getClass().getName(),"onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(getClass().getName(),"onDestroy");
    }

    @Override
    public void hideProgress() {
        callback.hideProgress();
    }

    @Override
    public void showProgress(int resId) {
        callback.showProgress(resId);
    }

    @Override
    public void showMessage(@NonNull String msg) {
        callback.showMessage(msg);
    }

    @Override
    public boolean isLoggedIn() {
        return callback.isLoggedIn();
    }

    @Override
    public void showError(@NonNull String errorMsg) {
        callback.showError(errorMsg);
    }
}
