package com.xh.study.bcy.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;

import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;

/**
 * Created by xh on 24/05/2018.
 */

public class ScaleRoundedImageView extends RoundedImageView {
    float scale = 0f;

    public ScaleRoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ScaleImageView);
        scale = a.getFloat(R.styleable.ScaleImageView_scale,scale);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(scale>0) {
            int width = MeasureSpec.getSize(widthMeasureSpec) - getPaddingLeft() - getPaddingRight();
            int height = (int) (width * scale + 0.5f);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    public void setScale(float scale) {
        this.scale = scale;
    }
}
