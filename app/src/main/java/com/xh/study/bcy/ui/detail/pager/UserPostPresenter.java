package com.xh.study.bcy.ui.detail.pager;

import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.adapter.model.PersonAskBeanModel;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;

/**
 * Created by xh on 30/05/2018.
 */

public class UserPostPresenter extends BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter {
    private Items items = new Items();
    private PersonAskBeanModel personAskBeanModel = new PersonAskBeanModel();
    private HeaderModel headerModel = new HeaderModel();

    @Override
    public void loadData(int loadType) {
        String params1 ;
        String params2 = Constant.PARAMS_USER_ASK_LIST_LOAD;
        switch (loadType) {
            case Constant.TYPE_LOAD:
                params1 = Constant.PARAMS_USER_POST_LOAD;
                loadAskTimeline(loadType,params1,params2);
                break;
            case Constant.TYPE_MORE:
                params1 = Constant.PARAMS_USER_POST_LOAD_MORE;
                loadTimeline(loadType,params1);
                break;
            case Constant.TYPE_REFRESH:
                params1 = Constant.PARAMS_USER_POST_REFRESH;
                loadAskTimeline(loadType,params1,params2);
                break;
        }
    }

    void loadTimeline(int loadType,String params){
        makeRestCall(RestProvider.getTimelineService().getUserPostTimeline(params),
            bean -> sendToView(
                view -> {
                    List list = new ArrayList();
                    switch (loadType) {
                        case Constant.TYPE_LOAD:
                            list.add(headerModel);
                            list.addAll(bean.getData());
                            view.loadData(list);
                            break;
                        case Constant.TYPE_MORE:
                            view.loadMore(bean.getData());
                            break;
                        case Constant.TYPE_REFRESH:
                            list.add(headerModel);
                            list.addAll(bean.getData());
                            view.loadData(list);
                            break;
                    }
                })
        );
    }

    void loadAsk(int loadType,String params){
        makeRestCall(RestProvider.getAskService().getListAsk(params),
            bean -> sendToView(
                view -> {
                    switch (loadType) {
                        case Constant.TYPE_LOAD:
                            view.loadData(bean.getData());
                            break;
                    }
                })
        );
    }

    void loadAskTimeline(int loadType,String params1,String params2){
        makeRestCall(RestProvider.getTimelineService().getUserPostTimeline(params1)
            .zipWith(RestProvider.getAskService().getListAsk(params2), (listBaseBean1, listBaseBean2) -> {
                List list = new ArrayList();
                list.addAll(listBaseBean1.getData());
                personAskBeanModel.setAskBeans(listBaseBean2.getData());
                list.add(1,personAskBeanModel);
                return list;
            }), list -> sendToView(
                view -> {
                    switch (loadType) {
                        case Constant.TYPE_LOAD:
                            view.loadData(list);
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
