package com.xh.study.bcy.adapter.holder;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.FeedBean;
import com.xh.study.bcy.ui.detail.CircleTagSmoothActivity;
import com.xh.study.bcy.ui.detail.SmoothPersonActivity;
import com.xh.study.bcy.ui.detail.pager.TagHotFragment;
import com.xh.study.bcy.ui.detail.pager.UserPostFragment;
import com.xh.study.bcy.ui.main.mainpage.pager.FriendFeedFragment;
import com.xh.study.bcy.ui.main.mainpage.pager.TimeLineFragment;
import com.xh.study.bcy.utils.FormatUtil;
import com.xh.study.bcy.utils.ToastUtil;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedItemHeaderFooterViewHolder extends RecyclerView.ViewHolder {
    TextView feedTimeTv;
    RelativeLayout headerInfo;
    FrameLayout feedHeaderContainer;

    CircleImageView feedHeadImg;
    RoundedImageView feedTagImg;


    FrameLayout feedAction;
    ImageView feedDislike;
    ImageView feedRankImg;
    TextView feedRankTv;
    TextView feedFocusUser;
    LinearLayout feedInfo;
    TextView feedTitle;
    TextView feedTime;
    TextView feedTitleType;


    LinearLayout groundBottomLly;
    RelativeLayout feedShareRly;
    ImageView feedShareImg;
    TextView feedShareTv;
    RelativeLayout feedCommentRly;
    ImageView feedCommentImg;
    TextView feedCommentTv;
    RelativeLayout feedLikeRly;
    ImageView feedLikeImg;
    TextView feedLikeTv;


    protected FeedItemHeaderFooterViewHolder(View view) {
        super(view);
        feedTimeTv = (TextView) view.findViewById(R.id.feed_time_tv);
        headerInfo = (RelativeLayout) view.findViewById(R.id.header_info);
        feedHeaderContainer = (FrameLayout) headerInfo.findViewById(R.id.feed_header_container);
        feedHeadImg = (CircleImageView) feedHeaderContainer.findViewById(R.id.feed_head_img);
        feedTagImg = (RoundedImageView) feedHeaderContainer.findViewById(R.id.feed_tag_img);
        feedAction = (FrameLayout) headerInfo.findViewById(R.id.feed_action);
        feedDislike = (ImageView) feedAction.findViewById(R.id.feed_dislike);
        feedRankImg = (ImageView) feedAction.findViewById(R.id.feed_rank_img);
        feedRankTv = (TextView) feedAction.findViewById(R.id.feed_rank_tv);
        feedFocusUser = (TextView) headerInfo.findViewById(R.id.feed_focus_user);
        feedInfo = (LinearLayout) headerInfo.findViewById(R.id.feed_info);
        feedTitle = (TextView) feedInfo.findViewById(R.id.feed_title);
        feedTime = (TextView) feedInfo.findViewById(R.id.feed_time);
        feedTitleType = (TextView) headerInfo.findViewById(R.id.feed_title_type);

        groundBottomLly = (LinearLayout) view.findViewById(R.id.ground_bottom_lly);
        feedShareRly = (RelativeLayout) groundBottomLly.findViewById(R.id.feed_share_rly);
        feedShareImg = (ImageView) feedShareRly.findViewById(R.id.feed_share_img);
        feedShareTv = (TextView) feedShareRly.findViewById(R.id.feed_share_tv);
        feedCommentRly = (RelativeLayout) groundBottomLly.findViewById(R.id.feed_comment_rly);
        feedCommentImg = (ImageView) feedCommentRly.findViewById(R.id.feed_comment_img);
        feedCommentTv = (TextView) feedCommentRly.findViewById(R.id.feed_comment_tv);
        feedLikeRly = (RelativeLayout) groundBottomLly.findViewById(R.id.feed_like_rly);
        feedLikeImg = (ImageView) feedLikeRly.findViewById(R.id.feed_like_img);
        feedLikeTv = (TextView) feedLikeRly.findViewById(R.id.feed_like_tv);
    }


    public void setHeadFoot(Fragment fragment, FeedBean.ItemDetailBean item) {
        Context context = fragment.getContext();

        if(fragment instanceof FriendFeedFragment|| fragment instanceof TagHotFragment){
            setUserHead(context,item);
        } else if(fragment instanceof TimeLineFragment){
            if(item.getPost_tags().isEmpty()) {
                setUserHead(context,item);
            }else {
                setPostTagHead(context,item);
            }
        }else if(fragment instanceof UserPostFragment){
            headerInfo.setVisibility(View.GONE);
            feedTimeTv.setText(FormatUtil.longToString(item.getCtime()*1000,"MM-dd"));
        }

        if (item.getShare_count() != 0) feedShareTv.setText(String.valueOf(item.getShare_count()));
        if (item.getReply_count() != 0) feedCommentTv.setText(String.valueOf(item.getReply_count()));
        if (item.getLike_count() != 0) feedLikeTv.setText(String.valueOf(item.getLike_count()));

        headerInfo.setOnClickListener(l -> CircleTagSmoothActivity.launch(context));
        feedHeadImg.setOnClickListener(l -> SmoothPersonActivity.launch(context));

        itemView.setOnClickListener(l->ToastUtil.custom(context, "itemView", 1).show());

        feedAction.setOnClickListener(l -> {
            ToastUtil.custom(context, "feedAction", 1).show();
        });

        feedShareRly.setOnClickListener(l -> {
            ToastUtil.custom(context, "feedShareRly", 1).show();
        });

        feedCommentRly.setOnClickListener(l -> {
            ToastUtil.custom(context, "feedCommentRly", 1).show();
        });

        feedLikeRly.setOnClickListener(l -> {
            ToastUtil.custom(context, "feedLikeRly", 1).show();
        });


    }


    private void setUserHead(Context context, FeedBean.ItemDetailBean item){
        Glide.with(context).load(item.getAvatar()).into(feedHeadImg);
        feedTitle.setText(item.getUname());
        feedHeadImg.setVisibility(View.VISIBLE);
        feedTagImg.setVisibility(View.GONE);

    }


    private void setPostTagHead(Context context, FeedBean.ItemDetailBean item){
        Glide.with(context).load(item.getPost_tags().get(0).getCover()).into(feedTagImg);
        feedTitle.setText(item.getPost_tags().get(0).getTag_name());
        feedHeadImg.setVisibility(View.GONE);
        feedTagImg.setVisibility(View.VISIBLE);

    }
}
