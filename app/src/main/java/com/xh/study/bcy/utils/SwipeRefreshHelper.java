package com.xh.study.bcy.utils;

import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by XH on 2018/1/25.
 */

public class SwipeRefreshHelper {
    private SwipeRefreshHelper() {
    }


    public static void init(final SwipeRefreshLayout swipeRefreshLayout, AppBarLayout barLayout, SwipeRefreshLayout.OnRefreshListener listener) {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(listener);
        barLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >= 0) {
                    swipeRefreshLayout.setEnabled(true);
                } else {
                    swipeRefreshLayout.setEnabled(false);
                }
            }
        });
    }

    public static void init(final SwipeRefreshLayout swipeRefreshLayout, SwipeRefreshLayout.OnRefreshListener listener) {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(listener);
    }

    public void enableRefresh(SwipeRefreshLayout swipeRefreshLayout, boolean isEnable) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setEnabled(isEnable);
        }
    }

    public void controlRefresh(SwipeRefreshLayout swipeRefreshLayout, boolean isRefresh) {
        if (swipeRefreshLayout != null){
            if(isRefresh!= swipeRefreshLayout.isRefreshing() ) {
                swipeRefreshLayout.setRefreshing(isRefresh);
            }
        }
    }
}
