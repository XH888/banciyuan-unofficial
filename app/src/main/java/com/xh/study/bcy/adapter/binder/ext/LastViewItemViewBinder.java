package com.xh.study.bcy.adapter.binder.ext;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xh.study.bcy.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 25/05/2018.
 */

    public class LastViewItemViewBinder extends ItemViewBinder {
        @NonNull
        @Override
        protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
            return new LastViewViewHolder(inflater.inflate(R.layout.timeline_lastview_notice, parent, false));
        }

        @Override
        protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @NonNull Object item) {

        }

        class LastViewViewHolder extends RecyclerView.ViewHolder {

            LastViewViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

