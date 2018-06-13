package com.xh.study.bcy.ui.base.loading;

import android.support.annotation.NonNull;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseActivity;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.widget.StateLayout;

import butterknife.BindView;

/**
 * Created by xh on 08/06/2018.
 */

public abstract class BaseLoadingActivity<V extends SmoothMvp.View,P extends BasePresenter<V>> extends BaseActivity<V,P> {
@BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;

    @Override
    public void showProgress(int resId) {
        baseProgressbar.loadingProgress();
    }

    @Override
    public void hideProgress() {
        baseProgressbar.loadingHide();
    }

    @Override
    public void showError(@NonNull String errorMsg) {
        baseProgressbar.loadingError();
    }

}
