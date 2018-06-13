package com.xh.study.bcy.adapter.binder;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.widget.EllipsisTextView;
import com.xh.study.bcy.widget.TagView;

import me.drakeet.multitype.ItemViewBinder;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedVideoBodyViewBinder extends ItemViewBinder<FeedBean,FeedVideoBodyViewBinder.FeedSingleViewHolder> {
    @NonNull
    @Override
    protected FeedSingleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FeedSingleViewHolder(inflater.inflate(R.layout.card_feed_single_body,parent,false));
    }


    @Override
    protected void onBindViewHolder(@NonNull FeedSingleViewHolder holder, @NonNull FeedBean item) {
        holder.feedIntro.setText(item.getItem_detail());
    }
    class FeedSingleViewHolder extends FeedItemHeaderFooterViewHolder {
        TextView feedContentTitle;
        EllipsisTextView feedIntro;
        RoundedImageView feedContentImg;
        GifImageView feedSingleGifImg;
        TagView feedTags;

        FeedSingleViewHolder(View view) {
            super(view);
            feedContentTitle = (TextView) view.findViewById(R.id.feed_content_title);
            feedIntro = (EllipsisTextView) view.findViewById(R.id.feed_intro);
            feedContentImg = (RoundedImageView) view.findViewById(R.id.feed_content_img);
            feedSingleGifImg = (GifImageView) view.findViewById(R.id.feed_single_gif_img);
            feedTags = (TagView) view.findViewById(R.id.feed_tags);
        }
    }
}
