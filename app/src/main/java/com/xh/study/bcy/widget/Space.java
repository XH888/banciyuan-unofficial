package com.xh.study.bcy.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xh.study.bcy.R;


/**
 * Created by xh on 02/05/2018.
 */
public class Space extends View {

    public Space(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        //这样设置阴影 滑动时候会产生重绘的Bug。
        setBackgroundResource(R.color.background);
        setElevation(5);

    }

    public Space(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Space(@NonNull Context context) {
        this(context, null);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
