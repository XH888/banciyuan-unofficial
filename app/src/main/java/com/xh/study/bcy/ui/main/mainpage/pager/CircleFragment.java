package com.xh.study.bcy.ui.main.mainpage.pager;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.binder.WeekHotWorkItemViewBinder;
import com.xh.study.bcy.adapter.binder.ext.CircleFooterViewBinder;
import com.xh.study.bcy.adapter.binder.ext.CircleHeaderViewBinder;
import com.xh.study.bcy.adapter.model.FooterModel;
import com.xh.study.bcy.adapter.model.TagCoreListModel;
import com.xh.study.bcy.bean.WeekHotWorkBean;
import com.xh.study.bcy.ui.base.loading.BaseLoadingFragment;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.widget.AppRefreshHeaderLayout;
import com.xh.study.bcy.widget.StateLayout;

import java.util.List;

import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by xh on 05/05/2018.
 */

public class CircleFragment extends BaseLoadingFragment<BaseLoadingMvp.View, CirclePresenter> implements  BaseLoadingMvp.View {

    @BindView(R.id.recleview)
    PullToRefreshRecyclerView pullToRefreshRecyclerView;
    @BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;

    RecyclerView mRecyclerView;
    MultiTypeAdapter adapter;

    public static CircleFragment newInstance() {
        return new CircleFragment();
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.maincircle_layout;
    }


    @Override
    protected void initRefreshLayout() {
        getPresenter().loadData(Constant.TYPE_LOAD);
    }

    @Override
    public void loadMore(@NonNull List items) {

    }
    @Override
    public void loadData(@NonNull List items) {
        hideProgress();
        if(items.isEmpty()){
            baseProgressbar.loadingEmpty();
            return;
        }
        adapter.getItems().clear();
        adapter.getItems().addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refreshNew(@NonNull List items){
        hideProgress();
        if(items.isEmpty()||adapter.getItems().containsAll(items)){
            return;
        }
        adapter.getItems().clear();
        adapter.getItems().addAll(items);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onNavigateClick() {

    }

    @Override
    public void showProgress(int resId) {
        if (adapter.getItems().isEmpty()) {
            baseProgressbar.loadingProgress();
        }
    }

    @Override
    public void hideProgress() {
        baseProgressbar.loadingHide();
        pullToRefreshRecyclerView.onRefreshComplete();
    }

    @Override
    protected void init() {
        initPullRefresh();
        initRecyclerView();
    }


    void initRecyclerView(){
        adapter = new MultiTypeAdapter();
        adapter.register(TagCoreListModel.class,new CircleHeaderViewBinder( getContext()));
        adapter.register(FooterModel.class,new CircleFooterViewBinder());
        adapter.register(WeekHotWorkBean.class,new WeekHotWorkItemViewBinder(getContext()));

        adapter.setItems(getPresenter().getItems());
        mRecyclerView = pullToRefreshRecyclerView.getRefreshableView();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(adapter);
    }

    void initPullRefresh(){
        pullToRefreshRecyclerView.setHeaderLayout(new AppRefreshHeaderLayout(this.getContext()));
        pullToRefreshRecyclerView.setOnRefreshListener(v -> getPresenter().loadData(Constant.TYPE_REFRESH));
        baseProgressbar.setOnReloadListener(v -> {
            baseProgressbar.loadingProgress();
            getPresenter().loadData(Constant.TYPE_LOAD);
        });
    }

    @NonNull
    @Override
    public CirclePresenter providePresenter() {
        return new CirclePresenter();
    }

}
