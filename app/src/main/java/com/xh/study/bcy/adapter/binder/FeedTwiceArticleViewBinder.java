package com.xh.study.bcy.adapter.binder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.widget.EllipsisTextView;
import com.xh.study.bcy.widget.ScaleRoundedImageView;
import com.xh.study.bcy.widget.TagView;

import me.drakeet.multitype.ItemViewBinder;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedTwiceArticleViewBinder extends ItemViewBinder<FeedBean,FeedTwiceArticleViewBinder.TwiceArticleViewHolder> {
    @NonNull
    @Override
    protected TwiceArticleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TwiceArticleViewHolder(inflater.inflate(R.layout.card_feed_twice_article,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TwiceArticleViewHolder holder, @NonNull FeedBean item) {

    }

    class TwiceArticleViewHolder extends RecyclerView.ViewHolder {
        ScaleRoundedImageView feedContentImg;
        TextView feedTitle;
        TextView feedTags;
        TextView feedSummary;
        TextView feedTwicePraise;
        TextView feedName;
        TwiceArticleViewHolder(View view) {
            super(view);
            feedContentImg = (ScaleRoundedImageView) view.findViewById(R.id.feed_content_img);
            feedTitle = (TextView) view.findViewById(R.id.feed_title);
            feedTags = (TextView) view.findViewById(R.id.feed_tags);
            feedSummary = (TextView) view.findViewById(R.id.feed_summary);
            feedTwicePraise = (TextView) view.findViewById(R.id.feed_twice_praise);
            feedName = (TextView) view.findViewById(R.id.feed_name);
        }
    }
}
