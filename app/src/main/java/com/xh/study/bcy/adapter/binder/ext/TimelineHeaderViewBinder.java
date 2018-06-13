package com.xh.study.bcy.adapter.binder.ext;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.model.HeaderModel;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class TimelineHeaderViewBinder extends ItemViewBinder<HeaderModel,TimelineHeaderViewBinder.TimelineHeaderItemHolder> {

    protected TimelineHeaderItemHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.timeline_local_circles, parent, false);
        LinearLayout container = linearLayout.findViewById(R.id.local_circles);

        //这里读取数据库信息载入数据
        container.addView( inflateItemView(container,R.string.i_focus,R.drawable.i_foucs) );
        container.addView( inflateItemView(container,R.string.work_circle_short,R.drawable.i_hotcircle) );
        container.addView( inflateItemView(container,R.string.tag_circle_short,R.drawable.i_interest) );

        return new TimelineHeaderItemHolder(linearLayout);
    }


    @Override
    protected void onBindViewHolder(@NonNull TimelineHeaderItemHolder holder, @NonNull HeaderModel item) {

    }

    View inflateItemView(ViewGroup container, @StringRes int strRes, @DrawableRes int drawRes){
        View itemView = LayoutInflater.from(container.getContext()).inflate( R.layout.timeline_local_circle_item,container,false);
        RoundedImageView iv_work =  itemView.findViewById(R.id.iv_work);
        TextView tv_work =  itemView.findViewById(R.id.tv_work);
        iv_work.setImageResource(drawRes);
        tv_work.setText(strRes);

        return itemView;
    }

    public class TimelineHeaderItemHolder extends RecyclerView.ViewHolder{
        public TimelineHeaderItemHolder(View itemView) {
            super(itemView);
        }
    }
}
