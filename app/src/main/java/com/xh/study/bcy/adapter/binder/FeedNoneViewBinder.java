package com.xh.study.bcy.adapter.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedNoneViewBinder extends ItemViewBinder<FeedBean,FeedNoneViewBinder.FeedNoneViewHolder> {
    private Context mContext ;
    public FeedNoneViewBinder(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    protected FeedNoneViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FeedNoneViewHolder(new LinearLayout(mContext));
    }


    @Override
    protected void onBindViewHolder(@NonNull FeedNoneViewHolder holder, @NonNull FeedBean item) {

    }
    class FeedNoneViewHolder extends FeedItemHeaderFooterViewHolder {
        FeedNoneViewHolder(View view) {
            super(view);
        }
    }

    public class GroupItemBigPicViewHolder {
    }
}
