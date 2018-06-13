package com.xh.study.bcy.adapter.binder;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.holder.FeedItemHeaderFooterViewHolder;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.widget.EllipsisTextView;
import com.xh.study.bcy.widget.TagView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 23/05/2018.
 */

public class FeedThirdBodyViewBinder extends ItemViewBinder<FeedBean,FeedThirdBodyViewBinder.FeedSingleViewHolder> {
    private Fragment mFragment ;
    public FeedThirdBodyViewBinder(Fragment fragment){
        mFragment = fragment;
    }
    @NonNull
    @Override
    protected FeedSingleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FeedSingleViewHolder(inflater.inflate(R.layout.card_feed_third_body,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull FeedSingleViewHolder holder, @NonNull FeedBean item) {
        if(item.getItem_detail().getGroup()==null)
            holder.feedContentTitle.setVisibility(View.GONE);
        else
            holder.feedContentTitle.setText(item.getItem_detail().getGroup().getName());
        holder.feedIntro.setText(item.getItem_detail());
        Glide.with(mFragment.getContext()).load(item.getItem_detail().getMulti().get(0).getPath()).into(holder.feedContentImgOne);
        Glide.with(mFragment.getContext()).load(item.getItem_detail().getMulti().get(1).getPath()).into(holder.feedContentImgTwo);
        Glide.with(mFragment.getContext()).load(item.getItem_detail().getMulti().get(2).getPath()).into(holder.feedContentImgThree);
        holder.groundPagenumTv.setText(mFragment.getString(R.string.multi_pic,String.valueOf( item.getItem_detail().getPic_num()-3 )));
        holder.feedTags.addPostTags(item.getItem_detail().getPost_tags());
        holder.setHeadFoot(mFragment,item.getItem_detail());

    }

    class FeedSingleViewHolder extends FeedItemHeaderFooterViewHolder {
        TextView feedContentTitle;
        EllipsisTextView feedIntro;
        RoundedImageView feedContentImgOne,feedContentImgTwo,feedContentImgThree;
        TextView groundPagenumTv;
        TagView feedTags;

        FeedSingleViewHolder(View view) {
            super(view);
            feedContentTitle = (TextView) view.findViewById(R.id.feed_content_title);
            feedIntro = (EllipsisTextView) view.findViewById(R.id.feed_intro);
            feedContentImgOne = (RoundedImageView) view.findViewById(R.id.feed_content_img_one);
            feedContentImgTwo = (RoundedImageView) view.findViewById(R.id.feed_content_img_two);
            feedContentImgThree = (RoundedImageView) view.findViewById(R.id.feed_content_img_three);
            groundPagenumTv = view.findViewById(R.id.ground_pagenum_tv);
            feedTags = (TagView) view.findViewById(R.id.feed_tags);
        }
    }
}
