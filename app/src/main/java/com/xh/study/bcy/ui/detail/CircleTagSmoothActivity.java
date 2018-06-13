package com.xh.study.bcy.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;
import com.makeramen.roundedimageview.RoundedImageView;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.TagStatusBean;
import com.xh.study.bcy.ui.base.loading.BaseLoadingActivity;
import com.xh.study.bcy.ui.base.loading.SmoothMvp;
import com.xh.study.bcy.ui.detail.pager.TagHotFragment;

import com.xh.study.bcy.utils.ViewHelper;
import com.xh.study.bcy.widget.FocusButton;
import com.xh.study.bcy.widget.StateLayout;
import com.xh.study.bcy.widget.TagView;
import com.xh.study.bcy.widget.stickheader.IpmlScrollChangListener;
import com.xh.study.bcy.widget.stickheader.StickHeaderLayout;
import com.xh.study.bcy.widget.tablayout.XTabLayout;

import butterknife.BindView;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * Created by xh on 27/05/2018.
 * 可以滑动的Tag视图
 */

public class CircleTagSmoothActivity extends BaseLoadingActivity<SmoothMvp.View, CircleTagSmoothPresenter> implements SmoothMvp.View<TagStatusBean> {
    @BindView(R.id.event_content_pager)
    ViewPager eventContentPager;
    @BindView(R.id.tablayout)
    XTabLayout tabLayout;
    @BindView(R.id.fold_header)
    StickHeaderLayout mStickHeaderLayout;
    @BindView(R.id.iv_acg_bg)
    ImageView ivAcgBg;
    @BindView(R.id.circle_header)
    RoundedImageView circleHeader;
    @BindView(R.id.tv_head_title)
    TextView tvHeadTitle;
    @BindView(R.id.tv_head_likenum)
    TextView tvHeadLikenum;
    @BindView(R.id.intro_tv)
    TextView introTv;
    @BindView(R.id.base_progressbar)
    StateLayout mBaseProgressbar;
    @BindView(R.id.left_block)
    View leftBlock;
    @BindView(R.id.circle_focus)
    FocusButton circleFocus;
    @BindView(R.id.info_line)
    RelativeLayout infoLine;
    @BindView(R.id.base_action_bar_title)
    TextView baseActionBarTitle;
    @BindView(R.id.view_focuse_bottom)
    RelativeLayout viewFocuseBottom;
    @BindView(R.id.float_head)
    RelativeLayout floatHead;
    @BindView(R.id.rela_tags)
    TagView relaTags;
    @BindView(R.id.rela_count)
    TextView relaCount;
    @BindView(R.id.rela_line)
    RelativeLayout relaLine;

    public static void launch(Context context){
        Intent intent = new Intent(context,CircleTagSmoothActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected int layout() {
        return R.layout.activity_smooth_tag_circle;
    }

    Fragment[] fragments = new Fragment[2];
    int currentPosition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventContentPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        fragments[0] = TagHotFragment.newInstance();
                        break;
                    case 1:
                        fragments[1] = TagHotFragment.newInstance();
                        break;
                }
                currentPosition = position;
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }

            final String titles[] = getResources().getStringArray(R.array.tag_detail);

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

        });
        tabLayout.setupWithViewPager(eventContentPager);
        eventContentPager.setCurrentItem(1);

        mStickHeaderLayout.setScroll(new IpmlScrollChangListener() {
            @Override
            public boolean isReadyForPull() {
                //对这里需要处理一些阻止默认事件。判断是否可以下滑
                return true;
            }

            @Override
            public void onStartScroll() {

            }

            @Override
            public void onStopScroll() {

            }

            @Override
            public void onScrollChange(int dy, int totallDy) {

                infoLine.setAlpha(1 - (float) dy / totallDy);
                relaLine.setAlpha(1 - (float) dy / totallDy);
                if (dy == totallDy) {
                    leftBlock.setVisibility(View.VISIBLE);
                    baseActionBarTitle.setVisibility(View.VISIBLE);
                    showHideFocusBottom(true);
                } else {
                    leftBlock.setVisibility(View.INVISIBLE);
                    baseActionBarTitle.setVisibility(View.INVISIBLE);
                    showHideFocusBottom(false);
                }
            }
        });
        getPresenter().loadData();
    }

    //当前是否显示float bottom layout
    boolean isShown;
    void showHideFocusBottom(boolean flag) {
        if (isShown == flag) {
            return;
        }
        isShown = flag;
        if (flag) {
            ((RelativeLayout) viewFocuseBottom.getParent()).animate().translationY(ViewHelper.dpToPx(this,0)).setDuration(400).start();
        } else {
            ((RelativeLayout) viewFocuseBottom.getParent()).animate().translationY(ViewHelper.dpToPx(this,68)).setDuration(400).start();
        }
    }

    @Override
    public void showProgress(int resId) {
        super.showProgress(resId);
        mBaseProgressbar.loadingProgress();
    }

    @Override
    public void updateUi(TagStatusBean bean) {
        mBaseProgressbar.loadingHide();
        StatusBarUtil.setTranslucentForImageView(this,0, floatHead);

        Glide.with(this).load(bean.getCover()).apply(bitmapTransform(new BlurTransformation(20, 10))).into(ivAcgBg);
        Glide.with(this).load(bean.getCover()).into(circleHeader);
        tvHeadTitle.setText(bean.getName());
        tvHeadLikenum.setText(this.getString(R.string.unit_focus, String.valueOf(bean.getTf_count())));
        introTv.setText(bean.getIntro());

        leftBlock.setVisibility(View.INVISIBLE);
        baseActionBarTitle.setVisibility(View.INVISIBLE);
        baseActionBarTitle.setText(bean.getName());

        if (bean.getRela() != null) {
            relaLine.setVisibility(View.VISIBLE);
            relaTags.addPostTags(bean.getRela());
            relaCount.setText(this.getString(R.string.releated_work_pink_unit, String.valueOf(bean.getRela().size())));
        }
    }


    @Override
    protected boolean canBack() {
        return false;
    }

    @NonNull
    @Override
    public CircleTagSmoothPresenter providePresenter() {
        return new CircleTagSmoothPresenter();
    }

}
