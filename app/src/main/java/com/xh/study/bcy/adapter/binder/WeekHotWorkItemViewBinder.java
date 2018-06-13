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
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.WeekHotWorkBean;
import com.xh.study.bcy.utils.ToastUtil;


import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 17/05/2018.
 */

public class WeekHotWorkItemViewBinder extends ItemViewBinder<WeekHotWorkBean,WeekHotWorkItemViewBinder.WeekHotWorkViewHolder>{

    private Context mContext;
    public WeekHotWorkItemViewBinder(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    protected WeekHotWorkItemViewBinder.WeekHotWorkViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new WeekHotWorkViewHolder(inflater.inflate(R.layout.circle_list_item,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull WeekHotWorkItemViewBinder.WeekHotWorkViewHolder holder, @NonNull WeekHotWorkBean item) {
        Glide.with(mContext).load(item.getCover()).into( holder.workIv);
        holder.worknameTv.setText(item.getReal_name());
        holder.WorkintroTv.setText(mContext.getResources().getString(R.string.work_unit,String.valueOf( item.getPost_count())));

        holder.itemView.setOnClickListener(l->{
            ToastUtil.custom(mContext,getClass().getName(),1).show();
        });
    }

    public class WeekHotWorkViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView workIv;
        ImageView goCircle;
        TextView worknameTv,WorkintroTv;
        public WeekHotWorkViewHolder(View itemView) {
            super(itemView);
            workIv = itemView.findViewById(R.id.iv_work);
            goCircle = itemView.findViewById(R.id.go_circle);
            worknameTv = itemView.findViewById(R.id.tv_workname);
            WorkintroTv = itemView.findViewById(R.id.tv_workintro);
        }
    }
}
