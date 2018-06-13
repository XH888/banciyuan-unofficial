package com.xh.study.bcy.adapter.binder;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.theophrast.ui.widget.SquareImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.bean.base.PostTagsBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class TimelineGridWriterViewBinder extends ItemViewBinder<FeedBean,TimelineGridWriterViewBinder.TimelineGridWriterViewHolder> {
    private Context mContext ;

    public TimelineGridWriterViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected TimelineGridWriterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TimelineGridWriterViewHolder(inflater.inflate(R.layout.timeline_grid_writer,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TimelineGridWriterViewHolder holder, @NonNull FeedBean item) {
        holder.itemTitle.setText(item.getItem_detail().getTitle());
        StringBuilder sb = new StringBuilder( item.getItem_detail().getWork());
        for(PostTagsBean postTagsBean : item.getItem_detail().getPost_tags()){
            sb.append("/");
            sb.append(postTagsBean.getTag_name());
        }
        holder.itemTag.setText( sb );

    }

    class TimelineGridWriterViewHolder extends RecyclerView.ViewHolder {
        FrameLayout writeItemOne;
        SquareImageView itemShadow;
        TextView itemTitle,itemTag;
        TimelineGridWriterViewHolder(View view) {
            super(view);
            itemShadow = view.findViewById(R.id.item_shadow);
            itemTitle = view.findViewById(R.id.item_title);
            itemTag = view.findViewById(R.id.item_tag);
        }
    }
}
