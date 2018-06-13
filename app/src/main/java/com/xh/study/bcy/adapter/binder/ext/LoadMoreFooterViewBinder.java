package com.xh.study.bcy.adapter.binder.ext;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.model.FooterModel;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 * 底部的加载更多的foot。
 */

public class LoadMoreFooterViewBinder extends ItemViewBinder<FooterModel,LoadMoreFooterViewBinder.LoadMoreFooterViewHolder>{
    @NonNull
    @Override
    protected LoadMoreFooterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LoadMoreFooterViewHolder(inflater.inflate(R.layout.feed_loading_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull LoadMoreFooterViewHolder holder, @NonNull FooterModel item) {
        switch (item.getType()){
            case 0:
                holder.startView.setVisibility(View.VISIBLE);
                break;
            case 1:
                holder.loadingView.setVisibility(View.VISIBLE);
                break;
            case -1:
                holder.endView.setVisibility(View.VISIBLE);
                break;
            default:
                holder.startView.setVisibility(View.VISIBLE);
                break;
        }

    }

    class LoadMoreFooterViewHolder extends RecyclerView.ViewHolder {
        LinearLayout startView;
        LinearLayout loadingView;
        LinearLayout endView;

        LoadMoreFooterViewHolder(View itemView) {
            super(itemView);
            startView = itemView.findViewById(R.id.start_view);
            loadingView = itemView.findViewById(R.id.loading_view);
            endView = itemView.findViewById(R.id.end_view);

            startView.setVisibility(View.GONE);
            loadingView.setVisibility(View.GONE);
            endView.setVisibility(View.GONE);
        }
    }
}
