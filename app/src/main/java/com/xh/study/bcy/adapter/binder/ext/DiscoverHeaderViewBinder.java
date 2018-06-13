package com.xh.study.bcy.adapter.binder.ext;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.xh.study.bcy.R;
import com.xh.study.bcy.adapter.model.HeaderModel;
import com.xh.study.bcy.bean.BannerBean;
import com.xh.study.bcy.bean.RelaPropsBean;
import com.xh.study.bcy.bean.base.PostTagsBean;
import com.xh.study.bcy.widget.ScaleRoundedImageView;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by xh on 25/05/2018.
 */

public class DiscoverHeaderViewBinder extends ItemViewBinder<HeaderModel,DiscoverHeaderViewBinder.DiscoverHeaderViewHolder> {
    private Context mContext ;
    public DiscoverHeaderViewBinder(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    protected DiscoverHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new DiscoverHeaderViewHolder(inflater.inflate(R.layout.discover_header,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull DiscoverHeaderViewHolder holder, @NonNull HeaderModel item) {
        StaggeredGridLayoutManager.LayoutParams clp = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
        clp.setFullSpan(true);
        holder.pagerBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Holder createHolder(View itemView) {
                return new ImageViewHolder(itemView);
            }
            @Override
            public int getLayoutId() {
                return R.layout.bangumi_img_item;
            }
        },item.getBanners());

        for(PostTagsBean relaBean :item.getRelas()){

        }
    }

    class ImageViewHolder extends Holder<BannerBean>{
        private ScaleRoundedImageView bannerImg ;
        ImageViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void initView(View itemView) {
            bannerImg = itemView.findViewById(R.id.bangumi_img);
        }

        @Override
        public void updateUI(BannerBean data) {
            bannerImg.setScale(0.312f);
            Glide.with(mContext).load(data.getCover()).into(bannerImg);
        }
    }

    class DiscoverHeaderViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout rlBanner;
        ConvenientBanner pagerBanner;
        LinearLayout relaTags;
        DiscoverHeaderViewHolder(View itemView) {
            super(itemView);
            relaTags = itemView.findViewById(R.id.rela_tags);
            rlBanner = itemView.findViewById(R.id.rl_banner);
            pagerBanner = rlBanner.findViewById(R.id.pager_banner);

        }
    }
}
