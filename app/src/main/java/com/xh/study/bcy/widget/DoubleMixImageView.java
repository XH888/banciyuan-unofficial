package com.xh.study.bcy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by xh on 18/05/2018.
 * 结合两张图片 中间隔开
 */

public class DoubleMixImageView extends ImageView {
    public DoubleMixImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void setTwoImage(String url1,String url2){
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
