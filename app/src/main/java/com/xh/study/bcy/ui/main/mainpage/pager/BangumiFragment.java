package com.xh.study.bcy.ui.main.mainpage.pager;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.binder.BangumiTitleViewBinder;
import com.xh.study.bcy.adapter.binder.BangumiViewBinder;
import com.xh.study.bcy.adapter.binder.ext.BangumiHeaderViewBinder;
import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.bean.BangumiBean;
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

public class BangumiFragment extends BaseLoadingFragment<BaseLoadingMvp.View, BangumiPresenter> implements  BaseLoadingMvp.View {

    @BindView(R.id.recleview)
    PullToRefreshRecyclerView mPullToRefreshRecyclerView;
    @BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;

    RecyclerView mRecyclerView ;
    MultiTypeAdapter adapter;

    @Override
    protected int fragmentLayout() {
        return R.layout.top_work_layout;
    }

    public static BangumiFragment newInstance() {
        return new BangumiFragment();
    }

    @Override
    protected void initRefreshLayout() {
        getPresenter().loadData(Constant.TYPE_LOAD);
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
        adapter.register(HeaderModel.class,new BangumiHeaderViewBinder());
        adapter.register(BangumiBean.class,new BangumiTitleViewBinder(getContext()));
        adapter.register(BangumiBean.DataBean.class,new BangumiViewBinder(getContext()));
        adapter.setItems(getPresenter().getItems());

        mRecyclerView = mPullToRefreshRecyclerView.getRefreshableView();
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(),3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(adapter.getItems().get(position) instanceof BangumiBean.DataBean){
                    return 1;
                }
                return 3;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);

        //设置分割线。这里的比例有点问题。
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                if(adapter.getItems().get(position) instanceof BangumiBean.DataBean) {
                    outRect.left = 12;
                    outRect.right = 12;
                }
            }
        });
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
    public BangumiPresenter providePresenter() {
        return new BangumiPresenter();
    }
}

