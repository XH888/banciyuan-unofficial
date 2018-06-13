package com.xh.study.bcy.ui.base.loading;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseFragment;
import com.xh.study.bcy.ui.base.mvp.BaseMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.ui.main.MainActivity;
import com.xh.study.bcy.widget.StateLayout;

import butterknife.BindView;

/**
 * Created by xh on 04/05/2018.
 */

public abstract class BaseLoadingFragment<V extends BaseLoadingMvp.View,P extends BasePresenter<V>> extends BaseFragment<V, P> implements BaseMvp.IView{
    @BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;


    // 标志位 标志已经初始化完成。
    protected boolean isPrepared;
    //标志位 fragment是否可见
    protected boolean isVisible;

    /**
     * Fragment数据的懒加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * fragment显示时才加载数据
     */
    protected void onVisible() {
        lazyLoad();
    }

    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        initRefreshLayout();
        isPrepared = false;
    }


    @Override
    protected void onFragmentCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Activity activity = getActivity();
        if(activity instanceof MainActivity) {
            ((MainActivity)activity).setCurrentLoadingFragment(this);
        }
        init();

        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void showError(@NonNull String errorMsg) {
        baseProgressbar.loadingError();
    }

    /**
     * 初始化控件
     */
    protected abstract void init();

    /**
     * 第一次 载入数据后 操作控件
     */
    protected abstract void initRefreshLayout();

    /**
     * 外部（navigation button）调用刷新
     */
    public abstract void onNavigateClick();

    /**
     * fragment不可见操作
     */
    protected void onInvisible() {}

}
