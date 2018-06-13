package com.xh.study.bcy.adapter.binder.ext;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.model.TagCoreListModel;
import com.xh.study.bcy.bean.TypeTagCircleBean;
import com.xh.study.bcy.bean.WeekHotWorkBean;
import com.xh.study.bcy.utils.CommonUtil;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 25/05/2018.
 */

public class CircleHeaderViewBinder extends ItemViewBinder<TagCoreListModel,CircleHeaderViewBinder. CircleHeadViewHolder> {

        Context mContext;
    public CircleHeaderViewBinder(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    protected CircleHeadViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new CircleHeadViewHolder(inflater.inflate(R.layout.main_circle_history_header, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull CircleHeadViewHolder holder, @NonNull TagCoreListModel item) {
        List<TypeTagCircleBean> typeTagCircleBeans = CommonUtil.getRandomList(item.getTypeTagCircleBeans(),1);

        TypeTagCircleBean typeTagCircleBean = typeTagCircleBeans.get(0);
        Glide.with(mContext).load(typeTagCircleBean.getTags_data().get(0).getCover()).into((RoundedImageView)holder.tagLine.findViewById(R.id.iv_work));
        ((TextView)holder.tagLine.findViewById(R.id.tv_workname)).setText(typeTagCircleBean.getType_name());
        ((TextView)holder.tagLine.findViewById(R.id.tv_post_count)).setText(mContext.getString(R.string.abc_action_bar_home_subtitle_description_format,typeTagCircleBean.getTags_data().get(0).getTag_name(),typeTagCircleBean.getTags_data().get(1).getTag_name(),typeTagCircleBean.getTags_data().get(2).getTag_name()));

        List<WeekHotWorkBean> weekHotWorkBeans = CommonUtil.getRandomList(item.getWeekHotWorkBeans(),3);
        Glide.with(mContext).load(weekHotWorkBeans.get(0).getCover()).into((RoundedImageView)holder.workLine.findViewById(R.id.iv_work));
        ((TextView)holder.workLine.findViewById(R.id.tv_workname)).setText(R.string.read_donjin);
        ((TextView)holder.workLine.findViewById(R.id.tv_post_count)).setText(mContext.getString(R.string.abc_action_bar_home_subtitle_description_format,weekHotWorkBeans.get(0).getReal_name(),weekHotWorkBeans.get(1).getReal_name(),weekHotWorkBeans.get(2).getReal_name()));


    }

    class CircleHeadViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout workLine;
        private RelativeLayout tagLine;

        CircleHeadViewHolder(View itemView) {
            super(itemView);
            workLine  = itemView.findViewById(R.id.work_line);
            tagLine  = itemView.findViewById(R.id.tag_line);
        }
    }
}
