package com.xh.study.bcy.ui.detail;

import com.xh.study.bcy.ui.base.loading.SmoothMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;

/**
 * Created by xh on 27/05/2018.
 */

public class SmoothPersonPresenter extends BasePresenter<SmoothMvp.View> implements SmoothMvp.Presenter{

    @Override
    public void loadData() {
        makeRestCall(RestProvider.getUserService().getUserDetail(Constant.PARAMS_PERSON_DETAIL_GET),
            bean->
                sendToView(v -> v.updateUi(bean.getData() ) )
            );
    }
}
