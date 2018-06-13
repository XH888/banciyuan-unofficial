package com.xh.study.bcy.adapter.binder.ext;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.model.FooterModel;
import com.xh.study.bcy.adapter.model.TagCoreListModel;
import com.xh.study.bcy.bean.TypeTagCircleBean;
import com.xh.study.bcy.bean.WeekHotWorkBean;
import com.xh.study.bcy.utils.CommonUtil;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 25/05/2018.
 */

public class CircleFooterViewBinder extends ItemViewBinder  {
    @NonNull
    @Override
    protected CircleFooterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view =inflater.inflate(R.layout.maincircle_footer, parent, false);
        ((TextView)view.findViewById(R.id.footer_goacg)).setText(R.string.discover_more_circle);
        return new CircleFooterViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item) {
        holder.itemView.setOnClickListener(l->{

        });
    }

    class CircleFooterViewHolder extends RecyclerView.ViewHolder {
        CircleFooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
