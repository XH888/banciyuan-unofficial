package com.xh.study.bcy.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.LoadingLayoutBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.xh.study.bcy.R;

import java.util.Random;


/**
 * Created by xh on 20/02/2018.
 */

public class AppRefreshHeaderLayout extends LoadingLayoutBase {

    static final String LOG_TAG = "PullToRefresh-AppHeaderLayout";

    private FrameLayout mInnerLayout;
    private ImageView bubbleImage;
    private ImageView pullRefreshImage;

    private final TextView mHeaderText;
    private CharSequence mPullLabel;
    private CharSequence mRefreshingLabel;
    private CharSequence mReleaseLabel;


    public AppRefreshHeaderLayout(Context context) {
        this(context, PullToRefreshBase.Mode.PULL_FROM_START);
    }

    public AppRefreshHeaderLayout(Context context, PullToRefreshBase.Mode mode) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_vertical, this);

        mInnerLayout = findViewById(R.id.fl_inner);
        mHeaderText = mInnerLayout.findViewById(R.id.pull_to_refresh_text);

        bubbleImage = mInnerLayout.findViewById(R.id.bubble);
        pullRefreshImage = mInnerLayout.findViewById(R.id.pull_to_refresh_image);

        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mInnerLayout.getLayoutParams();
        lp.gravity = mode == PullToRefreshBase.Mode.PULL_FROM_END ? Gravity.TOP : Gravity.BOTTOM ;
        mInnerLayout.setLayoutParams(lp);
        reset();
    }

    @Override
    public int getContentSize() {
        return bubbleImage.getHeight();
    }

    final int[] bubble = {
            R.drawable.moving_bubble,
            R.drawable.moving_clothes_bubble,
            R.drawable.moving_kejin_bubble,
            R.drawable.moving_aotu_bubble
    };
    @Override
    public void pullToRefresh() {

        mHeaderText.setText(mPullLabel);

        bubbleImage.setImageResource(bubble[new Random().nextInt(4)]);
        ((AnimationDrawable)bubbleImage.getDrawable()).start();

        pullRefreshImage.setImageResource(R.drawable.moving_pulldown_loading);
        ((AnimationDrawable)pullRefreshImage.getDrawable()).start();
    }

    @Override
    public void releaseToRefresh() {
        mHeaderText.setText(mReleaseLabel);
    }

    @Override
    public void onPull(float scaleOfLayout) {

    }

    @Override
    public void refreshing() {
        mHeaderText.setText(mRefreshingLabel);

        pullRefreshImage.setImageResource(R.drawable.moving_refreshing_loading);
        ((AnimationDrawable)pullRefreshImage.getDrawable()).start();
    }

    @Override
    public void reset() {
        // Load in labels
        mPullLabel = getContext().getString(R.string.pull_to_refresh_from_bottom_pull_label);
        mRefreshingLabel = getContext().getString(R.string.pull_to_refresh_from_bottom_refreshing_label);
        mReleaseLabel = getContext().getString(R.string.pull_to_refresh_from_bottom_release_label);
    }

    @Override
    public void setPullLabel(CharSequence pullLabel) {
        mPullLabel = pullLabel;
    }

    @Override
    public void setRefreshingLabel(CharSequence refreshingLabel) {
        mRefreshingLabel = refreshingLabel;
    }

    @Override
    public void setReleaseLabel(CharSequence releaseLabel) {
        mReleaseLabel = releaseLabel;
    }


}
