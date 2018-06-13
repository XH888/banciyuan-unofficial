package com.xh.study.bcy.ui.main.discover.pager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.binder.FeedTwiceNoteViewBinder;
import com.xh.study.bcy.adapter.binder.ext.DiscoverHeaderViewBinder;
import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.ui.base.loading.BaseLoadingFragment;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.widget.AppRefreshHeaderLayout;
import com.xh.study.bcy.widget.StateLayout;

import java.util.List;

import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by xh on 21/05/2018.
 */

public class IllustFragment extends BaseLoadingFragment<BaseLoadingMvp.View, IllustPresenter> implements  BaseLoadingMvp.View {

    @BindView(R.id.timeline_refresh_lv)
    PullToRefreshRecyclerView mPullToRefreshRecyclerView;
    @BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;

    RecyclerView mRecyclerView ;
    MultiTypeAdapter adapter;

    @Override
    protected int fragmentLayout() {
        return R.layout.discover_layout;
    }

    public static IllustFragment newInstance() {
        return new IllustFragment();
    }

    @Override
    protected void initRefreshLayout() {
        getPresenter().loadData(Constant.TYPE_LOAD);
    }

    @Override
    public void loadData(@NonNull List items) {
        hideProgress();
        if(items.isEmpty()){
            //弹出错误框
            return;
        }
        adapter.getItems().clear();
        adapter.getItems().addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refreshNew(@NonNull List items){
        hideProgress();
        if(items.isEmpty()){
            return;
        }
        if(adapter.getItems().containsAll(items)){
            return;
        }
        adapter.getItems().clear();
        adapter.getItems().addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadMore(@NonNull List items) {

    }

    @Override
    protected void init() {
        initPullRefresh();
        initRecyclerView();
    }

    @Override
    public void showProgress(int resId) {
        if (adapter.getItems().isEmpty()) {
            baseProgressbar.loadingProgress();
        }
    }

    @Override
    public void hideProgress() {
        mPullToRefreshRecyclerView.onRefreshComplete();
        baseProgressbar.loadingHide();
    }

    private void initRecyclerView() {
        adapter = new MultiTypeAdapter();
        adapter.register(HeaderModel.class,new DiscoverHeaderViewBinder(getContext()));
        adapter.register(FeedBean.class,new FeedTwiceNoteViewBinder(getContext()));
        //adapter.register(FeedBean.class,new FeedTwiceArticleViewBinder());

        adapter.setItems(getPresenter().getItems());

        mRecyclerView = mPullToRefreshRecyclerView.getRefreshableView();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);

        mRecyclerView.setAdapter(adapter);
    }

    private void initPullRefresh() {
        mPullToRefreshRecyclerView.setHeaderLayout(new AppRefreshHeaderLayout(this.getContext()));
        mPullToRefreshRecyclerView.setOnRefreshListener(v -> getPresenter().loadData(Constant.TYPE_REFRESH));
        baseProgressbar.setOnReloadListener(v -> {
            baseProgressbar.loadingProgress();
            getPresenter().loadData(Constant.TYPE_LOAD);
        });
    }

    @Override
    public void onNavigateClick() {

    }

    @NonNull
    @Override
    public IllustPresenter providePresenter() {
        return new IllustPresenter();
    }
}

