package com.xh.study.bcy.ui.main.discover.pager;

import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;

/**
 * Created by xh on 21/05/2018.
 */

public class IllustPresenter extends   BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter{

    private Items items = new Items();
    private HeaderModel headerModel = new HeaderModel();

    @Override
    public void loadData(@Constant.LoadType int type) {
        if(type == Constant.TYPE_LOAD){
            makeRestCall(RestProvider.getIllustService().getBanners(Constant.PARAMS_BANNER_GET)
                    .flatMap(bannerListBean->{
                        headerModel.setBanners(bannerListBean.getData());
                        return RestProvider.getIllustService().getRankTypes(Constant.PARAMS_RANK_TYPE_GET);
                    })
                    .flatMap(rankTypeBean->{
                        headerModel.setRankTypeBean(rankTypeBean.getData());
                        return RestProvider.getTagService().getRelaProps(Constant.PARAMS_RELA_PROP_GET);
                    })
                    .flatMap(relaPropsBean->{
                        headerModel.setRelas(relaPropsBean.getData().getRela());
                        return RestProvider.getCircleService().getItemHotTags(Constant.PARAMS_ITEM_HOTTAG_LOAD);
                    })
                    .map(itemHotTagListBean->{
                        List list = new ArrayList();
                        list.add(headerModel);
                        list.addAll(itemHotTagListBean.getData());
                        return list;
                    })
                    ,listBaseBean -> sendToView(view -> view.loadData(listBaseBean))
            );
        } else {
            makeRestCall(RestProvider.getCircleService().getItemHotTags(Constant.PARAMS_ITEM_HOTTAG_LOAD_MORE),
                    itemHotTagListBean -> sendToView(view -> view.loadMore(itemHotTagListBean.getData()))
            );
        }
    }

    @Override
    public List<?> getItems() {
        return items;
    }
}
