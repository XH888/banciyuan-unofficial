package com.xh.study.bcy.ui.main.mainpage.pager;

import com.xh.study.bcy.adapter.model.FooterModel;
import com.xh.study.bcy.adapter.model.TagCoreListModel;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;


import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;

/**
 * Created by xh on 29/04/2018.
 */
public class CirclePresenter extends BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter {

    private Items items = new Items();
    private TagCoreListModel tagCoreListModel = new TagCoreListModel();
    private FooterModel footerModel =new FooterModel();

    @Override
    public void loadData(@Constant.LoadType int loadtype){
        makeRestCall(RestProvider.getTagService().getTypeTagCircle(Constant.PARAMS_TYPE_TAG_CIRCLE_GET)
            .flatMap(typetagListBaseEntity->{
                tagCoreListModel.setTypeTagCircleBeans(typetagListBaseEntity.getData());
                return RestProvider.getCoreService().getWeekHotWork(Constant.PARAMS_WEEK_HOT_WORK_GET);
            })
            .map(weekhotListBaseEntity->{
                List list = new ArrayList();
                tagCoreListModel.setWeekHotWorkBeans(weekhotListBaseEntity.getData());
                list.add(tagCoreListModel);
                list.addAll(weekhotListBaseEntity.getData());
                list.add(footerModel);
                return list;
            }),list ->
                sendToView(view -> view.loadData(list))
            );
    }

    @Override
    public List getItems() {
        return items;
    }

}
