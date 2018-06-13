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
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.BangumiBean;
import com.xh.study.bcy.widget.ScaleRoundedImageView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class BangumiTitleViewBinder extends ItemViewBinder<BangumiBean, BangumiTitleViewBinder.BangumiTitleViewHolder> {
    private Context mContext;

    public BangumiTitleViewBinder(Context context) {
        mContext = context;
    }
    @NonNull
    @Override
    protected BangumiTitleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BangumiTitleViewHolder(inflater.inflate(R.layout.bangumi_title_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull BangumiTitleViewHolder holder, @NonNull BangumiBean item) {
        holder.bangumiTilte.setText(item.getType_name());
    }

    class BangumiTitleViewHolder extends RecyclerView.ViewHolder {
        TextView bangumiTilte;

        BangumiTitleViewHolder(View view) {
            super(view);
            bangumiTilte = view.findViewById(R.id.bangumi_tilte);
        }
    }
}
