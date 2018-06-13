package com.xh.study.bcy.ui.main.group.pager;

import com.xh.study.bcy.bean.HotGroupBean;
import com.xh.study.bcy.bean.base.BaseBean;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.RestProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.BiFunction;
import me.drakeet.multitype.Items;

/**
 * Created by xh on 21/05/2018.
 */

public class HotGroupPresenter extends   BasePresenter<BaseLoadingMvp.View> implements BaseLoadingMvp.Presenter{

    private Items items = new Items();

    @Override
    public void loadData(@Constant.LoadType int type) {
        String params = Constant.PARAMS_ATTEND_LOAD;
        switch (type){
            case Constant.TYPE_LOAD:
                params = Constant.PARAMS_ATTEND_LOAD;
                break;
            case Constant.TYPE_MORE:
                params = Constant.PARAMS_ATTEND_LOAD_MORE;
                break;
            case Constant.TYPE_REFRESH:
                params = Constant.PARAMS_ATTEND_REFRESH;
                break;
        }

        if(type==Constant.TYPE_MORE) {
            makeRestCall(RestProvider.getGroupService().getHotAttend(params).map(BaseBean::getData)
                    , groupListBean -> sendToView(view -> view.loadMore(groupListBean))
            );
        }else {
            makeRestCall(RestProvider.getGroupService().getHotGroupContent()
                    .zipWith(RestProvider.getGroupService().getHotAttend(params), (BiFunction<BaseBean<List<HotGroupBean>>, BaseBean<List<HotGroupBean>>, List<HotGroupBean>>) (listlistBean1, listlistBean2) -> {
                        List list = new ArrayList();
                        list.addAll(listlistBean1.getData());
                        list.addAll(listlistBean2.getData());
                        return list;
                    })
                    , groupListBean ->
                        sendToView(view -> {
                        if(type==Constant.TYPE_LOAD) {
                            view.loadData(groupListBean);
                        }
                        if(type==Constant.TYPE_REFRESH) {
                            view.refreshNew(groupListBean);
                        }
                    })
            );
        }
    }

    @Override
    public List<?> getItems() {
        return items;
    }
}
