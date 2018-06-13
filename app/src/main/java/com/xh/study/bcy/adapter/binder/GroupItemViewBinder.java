package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.HotGroupBean;
import com.xh.study.bcy.utils.ToastUtil;
import com.xh.study.bcy.widget.ScaleRoundedImageView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 26/05/2018.
 */

public class GroupItemViewBinder extends ItemViewBinder<HotGroupBean,GroupItemViewBinder.GroupItemViewHolder> {

    private Context mContext ;
    public GroupItemViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected GroupItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new GroupItemViewHolder(inflater.inflate(R.layout.group_main_item,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull GroupItemViewHolder holder, @NonNull HotGroupBean item) {
        if(item.getPosts().isEmpty()){
            holder.bestImg.setVisibility(View.GONE);
        }else {
            holder.bestImg.setVisibility(View.VISIBLE);
            if(item.getPosts().get(0).getCover()==null)
                holder.bestImg.setVisibility(View.GONE);
            else
                Glide.with(mContext).load(item.getPosts().get(0).getCover()).into(holder.bestImg);
        }
        holder.groupNewItemTitleOne.setText(item.getName());

        if(item.getIntro().isEmpty()) holder.talkIntro.setVisibility(View.GONE);
        else
            holder.talkIntro.setVisibility(View.VISIBLE);
            holder.talkIntro.setText(item.getIntro());

        if(item.getTags()==null||item.getTags().isEmpty()) holder.fromMark.setVisibility(View.GONE);
        else {
            holder.fromMark.setVisibility(View.VISIBLE);
            holder.tagText.setText(item.getTags().get(0).getTag_name());
        }
        holder.tvPostnum.setText(mContext.getString(R.string.person_talk_group_unit_2,String.valueOf(item.getPost_num())));

        holder.itemView.setOnClickListener(l->{
            ToastUtil.custom(mContext,getClass().getName(),1).show();
        });
    }

    class GroupItemViewHolder extends RecyclerView.ViewHolder{
        ImageView bestImg;
        TextView groupNewItemTitleOne;
        TextView talkIntro;
        TextView fromMark;
        TextView tagText;
        TextView tvPostnum;

        GroupItemViewHolder(View itemView) {
            super(itemView);
            groupNewItemTitleOne = itemView.findViewById(R.id.group_new_item_title_one);
            bestImg = itemView.findViewById(R.id.best_img);
            talkIntro = itemView.findViewById(R.id.talk_intro);
            fromMark = itemView.findViewById(R.id.from_mark);
            tagText = itemView.findViewById(R.id.tag_text);
            tvPostnum = itemView.findViewById(R.id.tv_postnum);
        }
    }
}
