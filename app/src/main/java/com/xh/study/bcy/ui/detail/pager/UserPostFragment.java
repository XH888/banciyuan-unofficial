package com.xh.study.bcy.ui.detail.pager;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.binder.AskUserViewBinder;
import com.xh.study.bcy.adapter.binder.FeedArticleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedImgArticleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedNoneBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedNoneViewBinder;
import com.xh.study.bcy.adapter.binder.FeedSingleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedThirdBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedTwiceBodyViewBinder;
import com.xh.study.bcy.adapter.binder.ext.LoadMoreFooterViewBinder;
import com.xh.study.bcy.adapter.binder.ext.PersonFilterHeaderViewBinder;
import com.xh.study.bcy.adapter.model.FooterModel;
import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.adapter.model.PersonAskBeanModel;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.ui.base.loading.BaseLoadingFragment;
import com.xh.study.bcy.ui.base.loading.BaseLoadingMvp;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.widget.StateLayout;

import java.util.List;

import butterknife.BindView;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by xh on 30/05/2018.
 */

public class UserPostFragment extends BaseLoadingFragment<BaseLoadingMvp.View,UserPostPresenter> implements BaseLoadingMvp.View {
    @BindView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recycle)
    RecyclerView mRecyclerView;
    @BindView(R.id.base_progressbar)
    StateLayout baseProgressbar;

    MultiTypeAdapter adapter;

    public static UserPostFragment newInstance() {
        return new UserPostFragment();
    }

    @Override
    public void loadData(@NonNull List items) {
        hideProgress();
        if(items.isEmpty()){
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
    public void showProgress(int resId) {
        if(adapter.getItems().isEmpty())
            baseProgressbar.loadingProgress();
    }

    @Override
    public void hideProgress() {
        baseProgressbar.loadingHide();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.circle_smooth_fragment;
    }

    @Override
    protected void init() {
        initRecyclerView();
        initSwipeRefreshLayout();
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(()->getPresenter().loadData(Constant.TYPE_REFRESH));
    }

    private void initRecyclerView() {
        adapter = new MultiTypeAdapter();
        adapter.register(HeaderModel.class,new PersonFilterHeaderViewBinder(this,mRecyclerView));
        adapter.register(FooterModel.class,new LoadMoreFooterViewBinder());
        adapter.register(PersonAskBeanModel.class, new AskUserViewBinder(getContext()));
        adapter.register(FeedBean.class).to(
                new FeedSingleBodyViewBinder(this),
                new FeedTwiceBodyViewBinder(this),
                new FeedThirdBodyViewBinder(this),
                new FeedImgArticleBodyViewBinder(this),
                new FeedArticleBodyViewBinder(this),
                new FeedNoneBodyViewBinder(this),
                new FeedNoneViewBinder(getContext())
        ).withClassLinker((position, feedBean) -> {
            switch (feedBean.getItem_detail().getFeedType()) {
                case Constant.TYPE_BEAN_NOTE:
                    switch (feedBean.getItem_detail().getPic_num()) {
                        case 1:
                            return FeedSingleBodyViewBinder.class;
                        case 2:
                            return FeedTwiceBodyViewBinder.class;
                        case 3:
                            return FeedThirdBodyViewBinder.class;
                    }
                    return FeedThirdBodyViewBinder.class;

                case Constant.TYPE_BEAN_ARTICLE:
                    if (TextUtils.isEmpty(feedBean.getItem_detail().getCover()) && !TextUtils.isEmpty(feedBean.getItem_detail().getContent())) {
                        return FeedArticleBodyViewBinder.class;
                    } else if (!TextUtils.isEmpty(feedBean.getItem_detail().getCover()) && TextUtils.isEmpty(feedBean.getItem_detail().getContent())) {
                        return FeedImgArticleBodyViewBinder.class;
                    }
                case Constant.TYPE_BEAN_GANSWER:
                    return FeedNoneBodyViewBinder.class;

                default:
                    return FeedNoneViewBinder.class;
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        adapter.setItems(getPresenter().getItems());
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


    @Override
    protected void initRefreshLayout() {
        getPresenter().loadData(Constant.TYPE_LOAD);
    }

    @Override
    public void onNavigateClick() {

    }

    @NonNull
    @Override
    public UserPostPresenter providePresenter() {
        return new UserPostPresenter();
    }
}
