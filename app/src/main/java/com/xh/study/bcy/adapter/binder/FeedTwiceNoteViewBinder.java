package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.bean.base.MultiBean;
import com.xh.study.bcy.utils.ToastUtil;
import com.xh.study.bcy.utils.ViewHelper;
import com.xh.study.bcy.widget.EllipsisTextView;
import com.xh.study.bcy.widget.ScaleRoundedImageView;
import com.xh.study.bcy.widget.TagView;

import me.drakeet.multitype.ItemViewBinder;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedTwiceNoteViewBinder extends ItemViewBinder<FeedBean,FeedTwiceNoteViewBinder.TwiceNoteViewHolder> {
    private Context mContext;
    public FeedTwiceNoteViewBinder(Context context){
        mContext  = context;
    }

    @NonNull
    @Override
    protected TwiceNoteViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TwiceNoteViewHolder(inflater.inflate(R.layout.card_feed_twice_note,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TwiceNoteViewHolder holder, @NonNull FeedBean item) {
        MultiBean multiBean = item.getItem_detail().getMulti().get(0);
        //1240  2500    2456    700     1024
        //800   1626    2000    1112    620
        //这里的流布局宽高加密了、操蛋。
        holder.feedContentImg.setScale( multiBean.getH()/multiBean.getW()  );

        Glide.with(mContext).load(multiBean.getPath()).into(holder.feedContentImg);
        holder.feedIntro.setText(item.getItem_detail().getPlain());
        holder.feedTwicePraise.setText(mContext.getString(R.string.zan_unit,String.valueOf( item.getItem_detail().getLike_count())));
        holder.feedName.setText(item.getItem_detail().getUname());

    }

    class TwiceNoteViewHolder extends RecyclerView.ViewHolder {
        ScaleRoundedImageView feedContentImg;
        TextView feedIntro;
        TextView feedTwicePraise;
        TextView feedName;

        TwiceNoteViewHolder(View view) {
            super(view);
            feedIntro = (TextView) view.findViewById(R.id.feed_intro);
            feedContentImg = (ScaleRoundedImageView) view.findViewById(R.id.feed_content_img);
            feedTwicePraise = (TextView) view.findViewById(R.id.feed_twice_praise);
            feedName = (TextView) view.findViewById(R.id.feed_name);
        }
    }
}
