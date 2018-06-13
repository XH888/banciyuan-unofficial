package com.xh.study.bcy.widget;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.xh.study.bcy.R;


/**
 * Created by xh on 23/04/2018.
 */

public class PopWaitFragment extends AppCompatDialogFragment {

    public final static String TAG = PopWaitFragment.class.getSimpleName();

    public static PopWaitFragment newInstance() {
        return new PopWaitFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pop_wait,container);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        Dialog dialog =  super.onCreateDialog(savedInstanceState) ;
        Window window = dialog.getWindow();
        if(window!=null){
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            window.setDimAmount(0);//背景模糊度
        }
        return dialog;
    }

}
