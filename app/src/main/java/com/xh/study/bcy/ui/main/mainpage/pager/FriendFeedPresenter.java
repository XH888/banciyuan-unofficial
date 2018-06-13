package com.xh.study.bcy.ui.main.mainpage.pager;

import com.xh.study.bcy.adapter.model.FooterModel;
import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.adapter.model.LastViewModel;
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

public class FriendFeedPresenter extends   BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter{

    private Items items = new Items();
    private HeaderModel headerModel = new HeaderModel();
    private LastViewModel lastViewModel = new LastViewModel();
    private FooterModel footerModel = new FooterModel();

    @Override
    public void loadData(@Constant.LoadType int type) {
        String params = Constant.PARAMS_FRIENDFEED_LOAD;
        switch (type){
            case Constant.TYPE_LOAD:
                params = Constant.PARAMS_FRIENDFEED_LOAD;
                break;
            case Constant.TYPE_MORE:
                params = Constant.PARAMS_FRIENDFEED_LOAD_MORE;
                break;
            case Constant.TYPE_REFRESH:
                params = Constant.PARAMS_FRIENDFEED_REFRESH;
                break;

        }
        makeRestCall(RestProvider.getTimelineService().getFriendFeed(params),
            feedListBaseBean -> {
                List list = new ArrayList();
                if(type==Constant.TYPE_LOAD){
                    list.add(headerModel);
                }
                list.addAll(feedListBaseBean.getData());
                if(type==Constant.TYPE_MORE){
                    items.remove(footerModel);
                    footerModel.setType(1);
                    list.add(footerModel);
                }
                if(type==Constant.TYPE_REFRESH){
                    items.remove(lastViewModel);
                    list.add(lastViewModel);
                }
                if(type==Constant.TYPE_LOAD){
                    items.remove(footerModel);
                    list.add(footerModel);
                }
                sendToView(view -> {
                    switch (type){
                        case Constant.TYPE_LOAD:
                            view.loadData(list);
                            break;
                        case Constant.TYPE_MORE:
                            view.loadMore(list);
                            break;
                        case Constant.TYPE_REFRESH:
                            view.refreshNew(list);
                            break;
                    }
                });
            }
        );
    }

    @Override
    public List<?> getItems() {
        return items;
    }
}
