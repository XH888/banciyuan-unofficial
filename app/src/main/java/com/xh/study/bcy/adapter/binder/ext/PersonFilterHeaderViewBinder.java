package com.xh.study.bcy.adapter.binder.ext;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.binder.AskUserViewBinder;
import com.xh.study.bcy.adapter.binder.FeedArticleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedImgArticleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedNoneBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedNoneViewBinder;
import com.xh.study.bcy.adapter.binder.FeedSingleBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedThirdBodyViewBinder;
import com.xh.study.bcy.adapter.binder.FeedTwiceBodyViewBinder;
import com.xh.study.bcy.adapter.binder.TimelineGridPicViewBinder;
import com.xh.study.bcy.adapter.binder.TimelineGridWriterViewBinder;
import com.xh.study.bcy.adapter.model.FooterModel;
import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.adapter.model.PersonAskBeanModel;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.utils.Constant;

import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by xh on 09/06/2018.
 */

public class PersonFilterHeaderViewBinder extends ItemViewBinder<HeaderModel, PersonFilterHeaderViewBinder.PersonFilterHeaderViewHolder> {
    private boolean isSingle = true;
    private RecyclerView mRecyclerView;
    private Fragment mFragment;

    public PersonFilterHeaderViewBinder(Fragment fragment, RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mFragment = fragment;
    }

    @NonNull
    @Override
    protected PersonFilterHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PersonFilterHeaderViewHolder(inflater.inflate(R.layout.person_filter, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PersonFilterHeaderViewHolder holder, @NonNull HeaderModel item) {
        MultiTypeAdapter adapter = (MultiTypeAdapter) mRecyclerView.getAdapter();
        holder.typeSwitch.setOnClickListener(l -> {
            isSingle = !isSingle;
            Log.d("PersonFilterHeader", "PersonFilterHeaderViewBinder:" + isSingle);
            if (isSingle) {
                holder.typeTv.setText(R.string.multi_line);
                holder.typeImg.setImageResource(R.drawable.multi_type_blue);
                adapter.register(PersonAskBeanModel.class, new AskUserViewBinder(mFragment.getContext()));
                adapter.register(FeedBean.class).to(
                        new FeedSingleBodyViewBinder(mFragment),
                        new FeedTwiceBodyViewBinder(mFragment),
                        new FeedThirdBodyViewBinder(mFragment),
                        new FeedImgArticleBodyViewBinder(mFragment),
                        new FeedArticleBodyViewBinder(mFragment),
                        new FeedNoneBodyViewBinder(mFragment),
                        new FeedNoneViewBinder(mFragment.getContext())
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
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mFragment.getContext(), LinearLayoutManager.VERTICAL, false));
            } else {
                holder.typeTv.setText(R.string.single_line);
                holder.typeImg.setImageResource(R.drawable.single_type_blue);
                adapter.register(FeedBean.class).to(
                        new TimelineGridPicViewBinder(mFragment.getContext()),
                        new TimelineGridWriterViewBinder(mFragment.getContext())
                ).withClassLinker((position, feedBean) -> {
                    switch (feedBean.getItem_detail().getFeedType()) {
                        case Constant.TYPE_BEAN_NOTE:
                            return TimelineGridPicViewBinder.class;
                        case Constant.TYPE_BEAN_ARTICLE:
                            return TimelineGridWriterViewBinder.class;
                        default:
                            return FeedNoneViewBinder.class;
                    }
                });
                GridLayoutManager gridLayoutManager = new GridLayoutManager(mFragment.getContext(), 3);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (adapter.getItems().get(position) instanceof HeaderModel || adapter.getItems().get(position) instanceof FooterModel) {
                            return 3;
                        }
                        return 1;
                    }
                });
            }
            adapter.notifyDataSetChanged();
        });
    }

    class PersonFilterHeaderViewHolder extends RecyclerView.ViewHolder {
        LinearLayout typeSwitch;
        TextView typeTv;
        ImageView typeImg;

        PersonFilterHeaderViewHolder(View itemView) {
            super(itemView);
            typeSwitch =itemView.findViewById(R.id.type_switch);
            typeTv =itemView.findViewById(R.id.type_tv);
            typeImg =itemView.findViewById(R.id.type_img);
        }
    }
}
