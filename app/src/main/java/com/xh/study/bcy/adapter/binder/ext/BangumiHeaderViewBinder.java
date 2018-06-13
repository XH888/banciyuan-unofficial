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
import com.xh.study.bcy.widget.TagView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 * 存在数据库中读取得，建立一个model对应
 */

public class BangumiHeaderViewBinder extends ItemViewBinder<HeaderModel,BangumiHeaderViewBinder.BangumiHeaderViewHolder>{
    @NonNull
    @Override
    protected BangumiHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BangumiHeaderViewHolder(inflater.inflate(R.layout.bangumi_readed_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull BangumiHeaderViewHolder holder, @NonNull HeaderModel item) {
       //holder.seenTags.addTags(item.get....);
    }

    class BangumiHeaderViewHolder extends RecyclerView.ViewHolder {
        TagView seenTags;
        BangumiHeaderViewHolder(View itemView) {
            super(itemView);
            seenTags = itemView.findViewById(R.id.seen_tags);
        }
    }
}
