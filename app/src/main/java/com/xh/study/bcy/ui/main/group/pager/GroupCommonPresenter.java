package com.xh.study.bcy.ui.main.group.pager;

import com.xh.study.bcy.bean.base.BaseBean;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;

import java.util.List;

import me.drakeet.multitype.Items;

/**
 * Created by xh on 21/05/2018.
 */

public class GroupCommonPresenter extends BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter {

    private Items items = new Items();

    @Override
    public void loadData(@Constant.LoadType int type) {
        String params = Constant.PARAMS_HOT_TAG_LOAD;
        switch (type) {
            case Constant.TYPE_LOAD:
                params = Constant.PARAMS_HOT_TAG_LOAD;
                break;
            case Constant.TYPE_MORE:
                params = Constant.PARAMS_HOT_TAG_LOAD;
                break;
            case Constant.TYPE_REFRESH:
                params = Constant.PARAMS_HOT_TAG_LOAD;
                break;
        }
        makeRestCall(RestProvider.getGroupService().getListHotTag(params).map(BaseBean::getData)
                , hotTagListBean -> sendToView(view ->
                {
                    switch (type) {
                        case Constant.TYPE_LOAD:
                            view.loadData(hotTagListBean);
                            break;
                        case Constant.TYPE_MORE:
                            view.loadMore(hotTagListBean);
                            break;
                        case Constant.TYPE_REFRESH:
                            view.refreshNew(hotTagListBean);
                            break;
                    }

                })
        );

    }

    @Override
    public List<?> getItems() {
        return items;
    }
}
