package com.xh.study.bcy.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.utils.ViewHelper;

/**
 * Created by xh on 27/05/2018.
 * 关注按钮
 */
public class FocusButton extends TextView {

    int selectedColor=getResources().getColor(R.color.pink);
    int unselectedColor=getResources().getColor(R.color.pink);
    String selectText;
    String unselectText;
    int boardColor  ;
    int selecedBoardColor ;
    boolean useDrawable=false,selectedUseLine,unselectedUseLine;

    boolean isCheck =false;

    GradientDrawable drawable;

    //水平padding 和 垂直padding
    int paddingH = ViewHelper.dpToPx(getContext(),15f);
    int paddingV = ViewHelper.dpToPx(getContext(),5f);


    public FocusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FocusButton);

        unselectedColor = a.getColor(R.styleable.FocusButton_unselectedColor, unselectedColor);
        unselectText = a.getString(R.styleable.FocusButton_unselectText);
        boardColor = a.getColor(R.styleable.FocusButton_boardColor, 0);

        selectText = a.getString(R.styleable.FocusButton_selectText);
        selectedColor = a.getColor(R.styleable.FocusButton_selectedColor, selectedColor);
        selecedBoardColor = a.getColor(R.styleable.FocusButton_selecedBoardColor, 0);

        useDrawable = a.getBoolean(R.styleable.FocusButton_useDrawable,false);

        isCheck = a.getBoolean(R.styleable.FocusButton_isCheck, isCheck);
        selectedUseLine = a.getBoolean(R.styleable.FocusButton_selectedUseLine, false);
        unselectedUseLine = a.getBoolean(R.styleable.FocusButton_unselectedUseLine, false);
        a.recycle();

        drawable = (GradientDrawable) getResources().getDrawable(R.drawable.shape_solid_trans_stoke_1_pink_radius_2);
        if(useDrawable) {
            toggleDrawStatus(isCheck);
        } else{
            toggleStatus(isCheck) ;
        }
        setOnClickListener(l -> {
            if(beforeDoCallBack!=null) {
                if (beforeDoCallBack.beforeDo()) {
                    isCheck = !isCheck;
                    toggleDrawStatus(isCheck);
                }
            }else {
                isCheck = !isCheck;
                toggleDrawStatus(isCheck);
            }
        });
        setIncludeFontPadding(true);
        setAllCaps(true);
        setPadding(paddingH,paddingV,paddingH,paddingV);
    }

    void toggleStatus(boolean isFocus){
        if(isFocus){

        }else {
            setText(unselectText);
            setTextColor(unselectedColor);
            setBackgroundColor(boardColor);
            drawable.setColor(selecedBoardColor);
            this.setBackground(drawable);
        }
    }

    void toggleDrawStatus(boolean isFocus){
        if(isFocus){
            this.setText(selectText);
            this.setTextColor(selectedColor);
            this.setBackgroundColor(selecedBoardColor);
            setBackgroundResource(R.drawable.shape_solid_black05_radius_3);
        }else {
            setText(unselectText);
            setTextColor(unselectedColor);
            setBackgroundColor(boardColor);
            setBackgroundResource(R.drawable.shape_solid_trans_stoke_05_block_line_radius_3);
        }
    }

    /**
     * 执行toggle之前的回调
     */
    private BeforeDoCallBack beforeDoCallBack;

    public void setBeforeDoCallBack(BeforeDoCallBack beforeDoCallBack) {
        this.beforeDoCallBack = beforeDoCallBack;
    }

    public interface BeforeDoCallBack{
        boolean beforeDo();
    }


}
