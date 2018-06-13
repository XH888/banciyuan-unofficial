package com.xh.study.bcy.ui.main.group.pager;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.binder.GroupItemBigPicHeaderViewBinder;
import com.xh.study.bcy.adapter.binder.GroupItemNoBigPicViewBinder;
import com.xh.study.bcy.bean.HotGroupBean;
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

public class HotGroupFragment extends BaseLoadingFragment<BaseLoadingMvp.View, HotGroupPresenter> implements  BaseLoadingMvp.View {

    @BindView(R.id.team_refresh_lv)
    PullToRefreshRecyclerView mPullToRefreshRecyclerView;
    @BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;

    RecyclerView mRecyclerView ;
    MultiTypeAdapter adapter;

    @Override
    protected int fragmentLayout() {
        return R.layout.team_fragment_layout;
    }

    public static HotGroupFragment newInstance() {
        return new HotGroupFragment();
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
        adapter.getItems().addAll(items);
        adapter.notifyDataSetChanged();
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
        adapter.register(HotGroupBean.class).to(
                new GroupItemNoBigPicViewBinder(getContext()),
                new GroupItemBigPicHeaderViewBinder(getContext())
        ).withClassLinker((position, hotGroupBean) -> {
            if ("banner".equals( hotGroupBean.getType() )){
                return GroupItemBigPicHeaderViewBinder.class;
            }
            return GroupItemNoBigPicViewBinder.class;
        });
        adapter.setItems(getPresenter().getItems());

        mRecyclerView = mPullToRefreshRecyclerView.getRefreshableView();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager lm = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItemCount = recyclerView.getAdapter().getItemCount();
                int lastVisibleItemPosition = lm.findLastVisibleItemPosition();
                int visibleItemCount = recyclerView.getChildCount();
                if (newState == RecyclerView.SCROLL_STATE_IDLE  && lastVisibleItemPosition == totalItemCount - 1 && visibleItemCount > 0) {
                    //加载更多
                    getPresenter().loadData(Constant.TYPE_MORE);
                }
            }
        });
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
    public HotGroupPresenter providePresenter() {
        return new HotGroupPresenter();
    }
}

