package com.xh.study.bcy.adapter.binder.ext;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.model.HeaderModel;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class FriendFeedHeaderViewBinder extends ItemViewBinder{
    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TimelineHeaderViewHolder(inflater.inflate(R.layout.timeline_user_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item) {
    }

    class TimelineHeaderViewHolder extends RecyclerView.ViewHolder {
        TimelineHeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
