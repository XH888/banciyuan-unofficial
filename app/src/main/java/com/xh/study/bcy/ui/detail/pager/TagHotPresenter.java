package com.xh.study.bcy.ui.detail.pager;

import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;

import java.util.List;

import me.drakeet.multitype.Items;

/**
 * Created by xh on 30/05/2018.
 */

public class TagHotPresenter extends BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter {
    private Items items = new Items();

    @Override
    public void loadData(int loadType) {
        String params = Constant.PARAMS_TAG_ITEM_HOTTAG_LOAD;
        switch (loadType) {
            case Constant.TYPE_LOAD:
                params = Constant.PARAMS_TAG_ITEM_HOTTAG_LOAD;
                break;
            case Constant.TYPE_MORE:
                params = Constant.PARAMS_TAG_ITEM_HOTTAG_LOAD_MORE;
                break;
            case Constant.TYPE_REFRESH:
                params = Constant.PARAMS_TAG_ITEM_HOTTAG_REFRESH;
                break;
        }

        makeRestCall(RestProvider.getCircleService().getItemHotTags(params),
            bean -> sendToView(
                view -> {
                    switch (loadType) {
                        case Constant.TYPE_LOAD:
                            view.loadData(bean.getData());
                            break;
                        case Constant.TYPE_MORE:
                            view.loadMore(bean.getData());
                            break;
                        case Constant.TYPE_REFRESH:
                            view.refreshNew(bean.getData());
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
