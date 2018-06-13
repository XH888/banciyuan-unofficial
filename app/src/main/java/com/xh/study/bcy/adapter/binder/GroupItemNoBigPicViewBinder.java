package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.HotGroupBean;
import com.xh.study.bcy.utils.ToastUtil;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 26/05/2018.
 */

public class GroupItemNoBigPicViewBinder extends ItemViewBinder<HotGroupBean,GroupItemNoBigPicViewBinder.GroupItemNoBigPicViewHolder> {

    private Context mContext ;
    public GroupItemNoBigPicViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected GroupItemNoBigPicViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new GroupItemNoBigPicViewHolder(inflater.inflate(R.layout.group_main_item_without_pic,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull GroupItemNoBigPicViewHolder holder, @NonNull HotGroupBean item) {
        holder.groupNewItemTitleOne.setText(item.getName());
        if(item.getPosts().isEmpty()) holder.talkIntro.setVisibility(View.GONE);
        else {
            holder.talkIntro.setVisibility(View.VISIBLE);
            holder.talkIntro.setText(item.getPosts().get(0).getPlain());
        }
        if(item.getTags().isEmpty()) holder.fromMark.setVisibility(View.GONE);
        else {
            holder.fromMark.setVisibility(View.VISIBLE);
            holder.tagText.setText(item.getTags().get(0).getTag_name());
        }
        //holder.tvPostnum.setText(mContext.getString(R.string.wait_for_you_join_n));
        holder.tvPostnum.setText(mContext.getString(R.string.person_talk_group_unit,String.valueOf(item.getPost_num())));

        holder.itemView.setOnClickListener(l->{
            ToastUtil.custom(mContext,getClass().getName(),1).show();
        });
    }

    class GroupItemNoBigPicViewHolder extends RecyclerView.ViewHolder{
        TextView groupNewItemTitleOne;
        TextView talkIntro;
        TextView fromMark;
        TextView tagText;
        TextView tvPostnum;

        GroupItemNoBigPicViewHolder(View itemView) {
            super(itemView);
            groupNewItemTitleOne = itemView.findViewById(R.id.group_new_item_title_one);
            talkIntro = itemView.findViewById(R.id.talk_intro);
            fromMark = itemView.findViewById(R.id.from_mark);
            tagText = itemView.findViewById(R.id.tag_text);
            tvPostnum = itemView.findViewById(R.id.tv_postnum);
        }
    }
}
