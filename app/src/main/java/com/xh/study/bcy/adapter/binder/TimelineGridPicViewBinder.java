package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.theophrast.ui.widget.SquareImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.BangumiBean;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.widget.ScaleRoundedImageView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class TimelineGridPicViewBinder extends ItemViewBinder<FeedBean,TimelineGridPicViewBinder.TimelineGridPicViewHolder> {
    private Context mContext ;

    public TimelineGridPicViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected TimelineGridPicViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TimelineGridPicViewHolder(inflater.inflate(R.layout.timeline_grid_pic,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TimelineGridPicViewHolder holder, @NonNull FeedBean item) {
        Glide.with(mContext).load(item.getItem_detail().getMulti().get(0).getPath()).into(holder.itemCover);
    }

    class TimelineGridPicViewHolder extends RecyclerView.ViewHolder {
        LinearLayout writeItemOne;
        SquareImageView itemCover;
        TimelineGridPicViewHolder(View view) {
            super(view);
            writeItemOne = view.findViewById(R.id.write_item_one);
            itemCover = view.findViewById(R.id.item_cover);
        }
    }
}
