package com.xh.study.bcy.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/**
 * Created by XH on 2018/1/26.
 */

public class MyAutoCompleteTextView extends AutoCompleteTextView{
    private String[] emailSufixs = new String[] { "@163.com", "@gmail.com", "@hotmail.com" };
    public MyAutoCompleteTextView(Context context) {
        super(context);
        init(context);
    }

    public MyAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setAdapterString(String[] es) {
        if(es != null && es.length > 0)
            this.emailSufixs = es;
    }

    private void init(final Context context) {
        this.setAdapter(new EmailAutoCompleteAdapter(context, android.R.layout.simple_dropdown_item_1line , emailSufixs));
        this.setThreshold(1);
        this.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    String text = MyAutoCompleteTextView.this.getText().toString();
                    if(!TextUtils.isEmpty(text))
                        performFiltering(text, KeyEvent.KEYCODE_UNKNOWN);
                }
            }
        });
    }

    @Override
    protected void replaceText(CharSequence text) {
        String t = this.getText().toString();
        int index = t.indexOf("@");
        if(index != -1)
            t = t.substring(0, index);
        super.replaceText(t + text);
    }

    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        String t = text.toString();
        int index = t.indexOf("@");
        if(index == -1) {
            if(t.matches("^[\\D]+$"))
                super.performFiltering("@", keyCode);
            else
                this.dismissDropDown();
        } else {
            super.performFiltering(t.substring(index), keyCode);
        }
    }

    private class EmailAutoCompleteAdapter extends ArrayAdapter<String> {
        int textViewResourceId;
        public EmailAutoCompleteAdapter(Context context, int textViewResourceId, String[] email_s) {
            super(context, textViewResourceId, email_s);
            this.textViewResourceId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = LayoutInflater.from(getContext()).inflate(textViewResourceId,null);
            TextView tv = (TextView) convertView;
            String t = MyAutoCompleteTextView.this.getText().toString();
            int index = t.indexOf("@");
            if(index != -1)
                t = t.substring(0, index);
            //将用户输入的文本与adapter中的email后缀拼接后，在下拉框中显示
            tv.setText(t + getItem(position));
            return convertView;
        }
    }
}
