package com.xh.study.bcy.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xh.study.bcy.R;


/**
 * Created by xh on 11/02/2018.
 */

public class ToastUtil {

    private static Toast toast;

    public static Toast custom(Context context, @StringRes int msgRes, int duration){
        return custom(context,context.getString(msgRes),duration);
    }

    public static Toast custom(Context context,String msg,int duration){
        if(toast==null){
            toast = new Toast(context);
        }
        View toastView = LayoutInflater.from(context).inflate(R.layout.mytoast_layout,(ViewGroup) null);
        TextView textview = toastView.findViewById(R.id.toast_content_tx);
        textview.setText(msg);
        toast.setView(toastView);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(duration);
        return toast;
    }
}
