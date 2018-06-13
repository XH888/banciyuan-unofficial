package com.xh.study.bcy.adapter.binder;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.widget.EllipsisTextView;
import com.xh.study.bcy.widget.TagView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedArticleBodyViewBinder extends ItemViewBinder<FeedBean,FeedArticleBodyViewBinder.FeedSingleViewHolder> {
    private Fragment mFragment;
    public FeedArticleBodyViewBinder(Fragment fragment){
        mFragment = fragment;
    }
    @NonNull
    @Override
    protected FeedSingleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FeedSingleViewHolder(inflater.inflate(R.layout.card_feed_article_body,parent,false));
    }


    @Override
    protected void onBindViewHolder(@NonNull FeedSingleViewHolder holder, @NonNull FeedBean item) {
        holder.feedIntro.setText(item.getItem_detail());
        holder.feedBodyTitle.setText(item.getItem_detail().getTitle());
        holder.feedSummary.setText(item.getItem_detail().getContent());
        holder.feedTags.addPostTags(item.getItem_detail().getPost_tags());
        holder.setHeadFoot(mFragment,item.getItem_detail());

    }
    class FeedSingleViewHolder extends FeedItemHeaderFooterViewHolder {
        EllipsisTextView feedIntro;
        TextView feedBodyTitle,feedSummary;
        TagView feedTags;

        FeedSingleViewHolder(View view) {
            super(view);
            feedIntro = (EllipsisTextView) view.findViewById(R.id.feed_intro);
            feedBodyTitle = view.findViewById(R.id.feed_body_title);
            feedSummary = view.findViewById(R.id.feed_summary);
            feedTags = (TagView) view.findViewById(R.id.feed_tags);
        }
    }
}
