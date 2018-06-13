package com.xh.study.bcy.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.evernote.android.state.State;
import com.evernote.android.state.StateSaver;
import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.mvp.BaseMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.ui.main.MainActivity;
import com.xh.study.bcy.utils.PreferencesUtil;

import com.xh.study.bcy.utils.ToastUtil;

import net.grandcentrix.thirtyinch.TiActivity;


import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

/**
 * Created by XH on 2018/1/25.
 */

public abstract class BaseActivity<V extends BaseMvp.IView,P extends BasePresenter<V>> extends TiActivity<P,V> implements BaseMvp.IView{
    public static String IS_LOGIN ="is_login";
    public static String KEY_USERNAME ="key_username";

    private long backPressTimer ;
    private Toast toast ;
    protected boolean isProgressShowing ;

    @State
    Bundle presenterStateBundle = new Bundle();

    @LayoutRes
    protected abstract int layout();
    protected abstract boolean canBack();

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        StateSaver.saveInstanceState(this, outState);
        getPresenter().onSaveInstanceState(presenterStateBundle);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(layout()!=0) {
            setContentView(layout());
            ButterKnife.bind(this);
        }
        if (savedInstanceState != null && !savedInstanceState.isEmpty()) {
            StateSaver.restoreInstanceState(this, savedInstanceState);
            getPresenter().onRestoreInstanceState(presenterStateBundle);
        }
        Log.d(getClass().getName(),"onCreate");
    }

    @Override
    protected void onPause() {
        Log.d(getClass().getName(),"onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d(getClass().getName(),"onResume");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(getClass().getName(),"onDestroy");
        super.onDestroy();
    }


    @Override
    public void showMessage(@NonNull String msgRes) {
        hideProgress();
        if (toast != null) toast.cancel();
        toast = Toasty.normal(this, msgRes, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void showProgress(int resId) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(@NonNull String errorMsg) {

    }

    private boolean canExit() {
        if (backPressTimer + 2000 > System.currentTimeMillis()) {
            return true;
        } else {
            ToastUtil.custom(this, R.string.more_click_exit, Toast.LENGTH_SHORT).show();
        }
        backPressTimer = System.currentTimeMillis();
        return false;
    }

    @Override
    public void onBackPressed() {
        if (this instanceof MainActivity) {
            if (canExit()) {
                super.onBackPressed();
            }
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean isLoggedIn() {
        return PreferencesUtil.getBoolean(this,IS_LOGIN);
    }

}
