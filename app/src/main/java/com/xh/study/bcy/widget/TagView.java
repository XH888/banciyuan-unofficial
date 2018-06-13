package com.xh.study.bcy.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.ReplayBean;
import com.xh.study.bcy.bean.base.PostTagsBean;
import com.xh.study.bcy.bean.base.UtagsBean;
import com.xh.study.bcy.utils.ToastUtil;
import com.xh.study.bcy.utils.ViewHelper;

import java.util.List;

/**
 * Created by xh on 12/02/2018.
 *
 * app:t_border_background="@color/white_25"
 app:t_border_height="20.0dip"
 app:t_border_radius="2.0dip"
 app:t_horizontal_spacing="8.0dip"
 app:t_line_color="@color/white_01"
 app:t_maxline="1"
 app:t_text_color="@color/white"
 app:t_text_padding_left="6.0dip"
 app:t_text_padding_right="6.0dip"
 app:t_text_size="12.0sp"
 */

public class TagView extends ViewGroup {

    Context mContext;

    private int mChildHeight;

    private int mMaxLines = 0;

    private int mVerticalInterval=0;
    private int mHorizontalInterval =20;
    private int[] mViewPos;


    int borderBackground;
    int borderHeight;
    int borderRadius;
    int lineColor;
    int textColor;
    int textPaddingLeft;
    int textPaddingRight;
    int textSize=ViewHelper.sp2px(getContext() ,12 );


    int hPadding = ViewHelper.dpToPx(getContext(),6);
    int vPadding = ViewHelper.dpToPx(getContext(),2);

    public TagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TagView);
        borderBackground  = ta.getResourceId(R.styleable.TagView_t_border_background, R.color.label_blue);
        textColor = ta.getResourceId(R.styleable.TagView_t_text_color, R.color.label_text_blue);
        textPaddingLeft = ta.getDimensionPixelSize(R.styleable.TagView_t_text_padding_left,hPadding);
        textPaddingRight = ta.getDimensionPixelSize(R.styleable.TagView_t_text_padding_right,hPadding);
        textSize = ta.getDimensionPixelSize(R.styleable.TagView_t_text_size,textSize);
        lineColor =ta.getResourceId(R.styleable.TagView_t_line_color, R.color.label_blue);
        mMaxLines = ta.getInt(R.styleable.TagView_t_maxline,mMaxLines);
        borderRadius = ta.getDimensionPixelSize(R.styleable.TagView_t_border_radius,ViewHelper.dpToPx(context,2));

        ta.recycle();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount;
        if ((childCount = getChildCount()) <= 0) {
            return;
        }
        int availableW = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int curRight = getMeasuredWidth() - getPaddingRight();
        int curTop = getPaddingTop();
        int curLeft = getPaddingLeft();
        int sPos = 0;
        mViewPos = new int[childCount * 2];
        for (int i = 0; i < childCount; i++) {
            final View childView = getChildAt(i);
            if (childView.getVisibility() != GONE) {
                int width = childView.getMeasuredWidth();
                    if (curLeft + width - getPaddingLeft() > availableW) {
                        curLeft = getPaddingLeft();
                        curTop += mChildHeight + mVerticalInterval;
                    }
                    mViewPos[i * 2] = curLeft;
                    mViewPos[i * 2 + 1] = curTop;
                    curLeft += width + mHorizontalInterval;
            }
        }

        // layout all child views
        for (int i = 0; i < mViewPos.length / 2; i++) {
            View childView = getChildAt(i);
            childView.layout(mViewPos[i * 2], mViewPos[i * 2 + 1],
                    mViewPos[i * 2] + childView.getMeasuredWidth(),
                    mViewPos[i * 2 + 1] + mChildHeight);
        }
    }

    /**
     * 计算子元素的宽高度
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);
        final int childCount = getChildCount();
        int lines = childCount == 0 ? 0 : getChildLines(childCount);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
//        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        if (childCount == 0) {
            setMeasuredDimension(0, 0);
        } else if (heightSpecMode == MeasureSpec.AT_MOST  || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            setMeasuredDimension(widthSpecSize, (mVerticalInterval + mChildHeight) * lines - mVerticalInterval + getPaddingTop() + getPaddingBottom());
        } else {
            setMeasuredDimension(widthSpecSize, heightSpecSize);
        }
    }

    /**
     * 根据子元素计算行数
     * @param childCount
     * @return
     */
    private int getChildLines(int childCount) {
        int availableW = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int lines = 1;
        for (int i = 0, curLineW = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            int dis = childView.getMeasuredWidth() + mHorizontalInterval;
            int height = childView.getMeasuredHeight();
            mChildHeight = i == 0 ? height : Math.min(mChildHeight, height);
            curLineW += dis;
            if (curLineW - mHorizontalInterval > availableW) {
                lines++;
                curLineW = dis;
            }
        }
        return mMaxLines <= 0 ? lines : mMaxLines;
    }

    public void addPostTags(List<PostTagsBean> tagBean){
        if(tagBean==null){
            return;
        }
        removeAllViews();
        for(PostTagsBean tag : tagBean){
            TextView textView = new TextView(mContext);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
            textView.setBackgroundResource(R.drawable.shape_solid_tagblue_radius_2);
            GradientDrawable drawable = (GradientDrawable) textView.getBackground();
            drawable.setColor(getResources().getColor(borderBackground));
            drawable.setCornerRadius(borderRadius);
            textView.setText(tag.getTag_name());
            if(tag.getType().equals("event")){
                textView.setCompoundDrawables(mContext.getDrawable(R.drawable.event_blue),null,null,null);
            }
            textView.setTextColor(getResources().getColor( textColor ));
            textView.setPadding(textPaddingLeft,vPadding,textPaddingRight,vPadding);
            addView(textView);

            textView.setOnClickListener(l->{
                ToastUtil.custom(getContext(),"textView:"+tag.getTag_name(),1).show();
            });
        }
        postInvalidate();
    }

    public void addUTags(List<UtagsBean> tags){
        if(tags==null){
            return;
        }
        removeAllViews();
        for(UtagsBean tag : tags){
            TextView textView = new TextView(mContext);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
            textView.setBackgroundResource(R.drawable.shape_solid_tagblue_radius_2);
            GradientDrawable drawable = (GradientDrawable) textView.getBackground();
            drawable.setColor(getResources().getColor(borderBackground));
            drawable.setCornerRadius(borderRadius);
            textView.setText( tag.getUt_name() );
            textView.setTextColor(getResources().getColor( textColor ));
            textView.setPadding(textPaddingLeft,vPadding,textPaddingRight,vPadding);
            addView(textView);
        }
        postInvalidate();
    }
}
