package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.utils.ToastUtil;
import com.xh.study.bcy.widget.EllipsisTextView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedNoneBodyViewBinder extends ItemViewBinder<FeedBean,FeedNoneBodyViewBinder.FeedSingleViewHolder> {
    private Fragment mFragment;
    public FeedNoneBodyViewBinder(Fragment fragment){
        mFragment = fragment;
    }
    @NonNull
    @Override
    protected FeedSingleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FeedSingleViewHolder(inflater.inflate(R.layout.card_feed_none_body,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull FeedSingleViewHolder holder, @NonNull FeedBean item) {
        holder.feedContentTitle.setText(item.getItem_detail().getGroup().getName());
        holder.feedIntro.setText(item.getItem_detail());
        holder.setHeadFoot(mFragment,item.getItem_detail());

    }
    class FeedSingleViewHolder extends FeedItemHeaderFooterViewHolder {
        TextView feedContentTitle;
        EllipsisTextView feedIntro;

        FeedSingleViewHolder(View view) {
            super(view);
            feedContentTitle = (TextView) view.findViewById(R.id.feed_content_title);
            feedIntro = (EllipsisTextView) view.findViewById(R.id.feed_intro);
        }
    }
}
