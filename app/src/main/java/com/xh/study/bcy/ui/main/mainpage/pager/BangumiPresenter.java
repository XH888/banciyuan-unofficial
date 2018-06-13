package com.xh.study.bcy.ui.main.mainpage.pager;

import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.bean.BangumiBean;
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

public class BangumiPresenter extends   BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter{

    private Items items = new Items();
    private HeaderModel headerModel = new HeaderModel();

    @Override
    public void loadData(@Constant.LoadType int type) {
        makeRestCall(RestProvider.getBangumiService().getList(),
            bangumiListBaseBean -> {
                List list = new ArrayList();
                list.add(headerModel);
                List<BangumiBean> bangumiBeans = bangumiListBaseBean.getData();
                for (BangumiBean bangumiBean:bangumiBeans){
                    list.add(bangumiBean);
                    list.addAll( bangumiBean.getData() );
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
