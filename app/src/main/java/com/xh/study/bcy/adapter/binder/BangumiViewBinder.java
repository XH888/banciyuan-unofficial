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
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.BangumiBean;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.widget.ScaleRoundedImageView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class BangumiViewBinder extends ItemViewBinder<BangumiBean.DataBean,BangumiViewBinder.BangumiViewHolder> {
    private Context mContext ;

    public BangumiViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected BangumiViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BangumiViewHolder(inflater.inflate(R.layout.bangumi_img_item,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull BangumiViewHolder holder, @NonNull BangumiBean.DataBean item) {
        holder.bangumiText.setText(item.getName());
        Glide.with(mContext).load(item.getCover()).into(holder.bangumiImg);
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) holder.itemView.getLayoutParams();
//        lp.leftMargin =24;
//        lp.leftMargin =24;
//        if (getPosition(holder)%3 == 1 || getPosition(holder)%3 == 0){
//            lp.leftMargin =12;
//        }
    }

    class BangumiViewHolder extends RecyclerView.ViewHolder {
        ScaleRoundedImageView bangumiImg;
        TextView bangumiText;
        BangumiViewHolder(View view) {
            super(view);
            bangumiImg = view.findViewById(R.id.bangumi_img);
            bangumiText = view.findViewById(R.id.bangumi_text);


            bangumiImg.setScale(1.5f);//这里只能设置这个比例了。
        }
    }
}
