package com.xh.study.bcy.adapter.binder;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.widget.EllipsisTextView;
import com.xh.study.bcy.widget.TagView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedImgArticleBodyViewBinder extends ItemViewBinder<FeedBean,FeedImgArticleBodyViewBinder.FeedSingleViewHolder> {
    Fragment mFragment ;
    public FeedImgArticleBodyViewBinder(Fragment fragment){
        mFragment = fragment;
    }
    @NonNull
    @Override
    protected FeedSingleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FeedSingleViewHolder(inflater.inflate(R.layout.card_feed_img_article_body,parent,false));
    }


    @Override
    protected void onBindViewHolder(@NonNull FeedSingleViewHolder holder, @NonNull FeedBean item) {
        holder.feedIntro.setText(item.getItem_detail());
        Glide.with(mFragment.getContext()).load(item.getItem_detail().getCover()).into(holder.feedContentImg);
        holder.feedBodyTitle.setText(item.getItem_detail().getTitle());
        holder.feedTags.addPostTags(item.getItem_detail().getPost_tags());
        holder.setHeadFoot(mFragment,item.getItem_detail());

    }
    class FeedSingleViewHolder extends FeedItemHeaderFooterViewHolder {
        EllipsisTextView feedIntro;
        RoundedImageView feedContentImg;
        TextView feedBodyTitle;
        TagView feedTags;

        FeedSingleViewHolder(View view) {
            super(view);
            feedIntro = (EllipsisTextView) view.findViewById(R.id.feed_intro);
            feedContentImg = (RoundedImageView) view.findViewById(R.id.feed_content_img);
            feedBodyTitle =  (TextView) view.findViewById(R.id.feed_body_title);
            feedTags = (TagView) view.findViewById(R.id.feed_tags);
        }
    }
}
