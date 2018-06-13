package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.HotGroupBean;
import com.xh.study.bcy.widget.ScaleRoundedImageView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 26/05/2018.
 */

public class GroupItemBigPicViewBinder extends ItemViewBinder<HotGroupBean,GroupItemBigPicViewBinder.GroupItemBigPicViewHolder> {

    private Context mContext ;
    public GroupItemBigPicViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected GroupItemBigPicViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new GroupItemBigPicViewHolder(inflater.inflate(R.layout.group_main_item_big_pic,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull GroupItemBigPicViewHolder holder, @NonNull HotGroupBean item) {

    }

    class GroupItemBigPicViewHolder extends RecyclerView.ViewHolder{
        TextView groupNewItemTitleOne;
        ScaleRoundedImageView imgBig;
        TextView talkIntro;
        TextView fromMark;
        TextView tagText;
        TextView tvPostnum;

        GroupItemBigPicViewHolder(View itemView) {
            super(itemView);
            groupNewItemTitleOne = itemView.findViewById(R.id.group_new_item_title_one);
            imgBig = itemView.findViewById(R.id.img_big);
            talkIntro = itemView.findViewById(R.id.talk_intro);
            fromMark = itemView.findViewById(R.id.from_mark);
            tagText = itemView.findViewById(R.id.tag_text);
            tvPostnum = itemView.findViewById(R.id.tv_postnum);
        }
    }
}
