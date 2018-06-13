package com.xh.study.bcy.ui.detail;

import com.xh.study.bcy.ui.base.loading.SmoothMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;

/**
 * Created by xh on 27/05/2018.
 */

public class CircleTagSmoothPresenter extends BasePresenter<SmoothMvp.View> implements SmoothMvp.Presenter{

    @Override
    public void loadData() {
        makeRestCall(RestProvider.getTagService().getTagStatus(Constant.PARAMS_TAG_STATUS_GET),
            bean->
                sendToView(v -> v.updateUi(bean.getData() ) )
            );
    }
}
