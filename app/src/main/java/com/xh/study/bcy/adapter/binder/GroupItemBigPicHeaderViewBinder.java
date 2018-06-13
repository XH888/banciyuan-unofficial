package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.HotGroupBean;
import com.xh.study.bcy.utils.ToastUtil;
import com.xh.study.bcy.widget.ScaleImageView;
import com.xh.study.bcy.widget.ScaleRoundedImageView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 26/05/2018.
 */

public class GroupItemBigPicHeaderViewBinder extends ItemViewBinder<HotGroupBean,GroupItemBigPicHeaderViewBinder.GroupItemBigPicHeaderViewHolder> {

    private Context mContext ;
    public GroupItemBigPicHeaderViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected GroupItemBigPicHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new GroupItemBigPicHeaderViewHolder(inflater.inflate(R.layout.group_main_item_big_pic_header,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull GroupItemBigPicHeaderViewHolder holder, @NonNull HotGroupBean item) {
        holder.groupNewItemTitleOne.setText(item.getIntro());
        Glide.with(mContext).load(item.getCover()).into(holder.imgBig);

        holder.itemView.setOnClickListener(l->{
            ToastUtil.custom(mContext,getClass().getName(),1).show();
        });
    }

    class GroupItemBigPicHeaderViewHolder extends RecyclerView.ViewHolder{
        TextView groupNewItemTitleOne;
        ScaleImageView imgBig;

        GroupItemBigPicHeaderViewHolder(View itemView) {
            super(itemView);
            groupNewItemTitleOne = itemView.findViewById(R.id.group_new_item_title_one);
            imgBig = itemView.findViewById(R.id.img_big);
        }
    }
}
