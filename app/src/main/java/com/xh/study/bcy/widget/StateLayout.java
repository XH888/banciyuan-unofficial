package com.xh.study.bcy.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.xh.study.bcy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xh on 01/05/2018.
 */

public class StateLayout extends RelativeLayout {
    @BindView(R.id.progressbar_nodata_layout)
    LinearLayout progressbar_nodata_layout;
    @BindView(R.id.progressbar_failed_layout)
    LinearLayout progressbar_failed_layout;
    @BindView(R.id.progressbar_loading_layout)
    LinearLayout progressbar_loading_layout;

    private OnClickListener onReloadListener;

    public StateLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void loadingProgress() {
        loadingHide();
        progressbar_loading_layout.setVisibility(VISIBLE);
    }

    public void loadingError() {
        loadingHide();
        progressbar_failed_layout.setVisibility(VISIBLE);
    }

    public void loadingEmpty() {
        loadingHide();
        progressbar_nodata_layout.setVisibility(VISIBLE);
    }

    public void loadingHide(){
        progressbar_loading_layout.setVisibility(GONE);
        progressbar_nodata_layout.setVisibility(GONE);
        progressbar_failed_layout.setVisibility(GONE);
    }

    public void setOnReloadListener(OnClickListener onReloadListener) {
        this.onReloadListener = onReloadListener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inflate(getContext(), R.layout.base_progressbar_layout, this);
        ButterKnife.bind(this);
        progressbar_failed_layout.setOnClickListener(view->{
            if(onReloadListener!=null)
                onReloadListener.onClick(view);
        });
    }


    @Override
    protected void onDetachedFromWindow() {
        onReloadListener = null;
        super.onDetachedFromWindow();
    }
}
