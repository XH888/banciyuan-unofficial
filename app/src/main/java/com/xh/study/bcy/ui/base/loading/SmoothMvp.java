package com.xh.study.bcy.ui.base.loading;

import com.xh.study.bcy.ui.base.mvp.BaseMvp;

/**
 * Created by xh on 27/05/2018.
 */

public interface SmoothMvp {
    interface Presenter extends BaseMvp.IPresenter{
        void loadData();
    }

    interface View<T> extends BaseMvp.IView{
        void updateUi( T bean);
    }
}
