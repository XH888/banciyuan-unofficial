package com.xh.study.bcy.ui.main.mainpage.pager;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.binder.FeedArticleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedImgArticleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedNoneBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedNoneViewBinder;
import com.xh.study.bcy.adapter.binder.FeedSingleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedThirdBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedTwiceBodyViewBinder;
import com.xh.study.bcy.adapter.binder.ext.LastViewItemViewBinder;
import com.xh.study.bcy.adapter.binder.ext.LoadMoreFooterViewBinder;
import com.xh.study.bcy.adapter.binder.ext.FriendFeedHeaderViewBinder;
import com.xh.study.bcy.adapter.model.FooterModel;
import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.adapter.model.LastViewModel;
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

public class FriendFeedFragment extends BaseLoadingFragment<BaseLoadingMvp.View, FriendFeedPresenter> implements  BaseLoadingMvp.View {

    @BindView(R.id.timeline_refresh_lv)
    PullToRefreshRecyclerView mPullToRefreshRecyclerView;
    @BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;
    @BindView(R.id.timeline_notice)
    TextView timelineNotice;

    RecyclerView mRecyclerView ;
    MultiTypeAdapter adapter;

    @Override
    protected int fragmentLayout() {
        return R.layout.timeline_layout;
    }

    public static FriendFeedFragment newInstance() {
        return new FriendFeedFragment();
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
        }else {
            timelineNotice.setText( R.string.focus_refreshed );
            showNotice();
        }

        adapter.getItems().clear();
        adapter.getItems().addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void refreshNew(@NonNull List items){
        hideProgress();
        if (items.isEmpty()) {
            timelineNotice.setText(getString(R.string.no_more_new));
        } else {
            timelineNotice.setText( getString(R.string.new_content_nums, items.size()));
        }
        showNotice();
        adapter.getItems().addAll(1,items);
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
        adapter.register(HeaderModel.class,new FriendFeedHeaderViewBinder());
        adapter.register(FooterModel.class,new LoadMoreFooterViewBinder());
        adapter.register(LastViewModel.class,new LastViewItemViewBinder());
        adapter.register(FeedBean.class).to(
                new FeedSingleBodyViewBinder(this),
                new FeedTwiceBodyViewBinder(this),
                new FeedThirdBodyViewBinder(this),
                new FeedImgArticleBodyViewBinder(this),
                new FeedArticleBodyViewBinder(this),
                new FeedNoneBodyViewBinder(this),
                new FeedNoneViewBinder(getContext())
        ).withClassLinker((position, friendFeedBean) ->{
            switch (friendFeedBean .getItem_detail().getFeedType()){
                case Constant.TYPE_BEAN_NOTE:
                    switch (friendFeedBean.getItem_detail().getPic_num()) {
                        case 1:
                            return FeedSingleBodyViewBinder.class;
                        case 2:
                            return FeedTwiceBodyViewBinder.class;
                        case 3:
                            return FeedThirdBodyViewBinder.class;
                    }
                    return FeedThirdBodyViewBinder.class;

                case Constant.TYPE_BEAN_ARTICLE:
                    if(TextUtils.isEmpty( friendFeedBean.getItem_detail().getCover() ) && !TextUtils.isEmpty( friendFeedBean.getItem_detail().getContent() )) {
                        return FeedArticleBodyViewBinder.class;
                    }else if(!TextUtils.isEmpty( friendFeedBean.getItem_detail().getCover() ) && TextUtils.isEmpty( friendFeedBean.getItem_detail().getContent() )) {
                        return FeedImgArticleBodyViewBinder.class;
                    }
                case Constant.TYPE_BEAN_GANSWER:
                    return FeedNoneBodyViewBinder.class;

                default:
                    return FeedNoneViewBinder.class;
            }
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

    void showNotice() {
        timelineNotice.animate().alpha(1f).translationY(0f).setDuration(500).start();
        timelineNotice.postOnAnimationDelayed(new Runnable() {
            @Override
            public void run() {
                timelineNotice.animate().alpha(0f).translationY(-28f).setDuration(500).start();
            }
        },1500);
    }

    @Override
    public void onNavigateClick() {

    }

    @NonNull
    @Override
    public FriendFeedPresenter providePresenter() {
        return new FriendFeedPresenter();
    }
}

