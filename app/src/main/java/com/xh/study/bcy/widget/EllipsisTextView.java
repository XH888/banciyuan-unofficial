package com.xh.study.bcy.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.utils.Constant;
import com.xh.study.bcy.utils.ToastUtil;

/**
 * Created by xh on 12/02/2018.
 *
 */

public class EllipsisTextView extends TextView  {

    private Context mContext ;

    public EllipsisTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setText(FeedBean.ItemDetailBean item){
//        if(TextUtils.isEmpty(pain)){
//            switch (item.getOtype()){
//                case Constant.OTYPE_DRAWER:
//                    pain = mContext.getString(R.string.post_draw);
//                    break;
//                case Constant.OTYPE_COSER:
//                    pain = mContext.getString(R.string.post_cos);
//                    break;
//                case Constant.OTYPE_ZHIPIN:
//                    pain = mContext.getString(R.string.post_goods);
//                    break;
//                case Constant.OTYPE_WRITER:
//                    pain = mContext.getString(R.string.post_article);
//                    break;
//                case Constant.OTYPE_USER:
//                    pain = mContext.getString(R.string.post_comment);
//                    break;
//            }
//        }
        String uname=item.getUname();
        String plain ;
        if(item.getPlain()!=null){
            plain=item.getPlain();
        }else {
            plain = item.getSummary();
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uname);
        stringBuilder.append("：");
        stringBuilder.append(plain);
        Spannable spannable = new SpannableString(stringBuilder);
        spannable.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.blue)),0,uname.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(spannable);

        setOnClickListener(l->{
            ToastUtil.custom(mContext,uname,1).show();
        });
    }

}
