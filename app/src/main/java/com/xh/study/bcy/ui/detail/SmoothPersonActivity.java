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
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaeger.library.StatusBarUtil;
import com.xh.study.bcy.R;
import com.xh.study.bcy.bean.UserBean;
import com.xh.study.bcy.ui.base.loading.BaseLoadingActivity;
import com.xh.study.bcy.ui.base.loading.SmoothMvp;
import com.xh.study.bcy.ui.detail.pager.UserPostFragment;
import com.xh.study.bcy.utils.FormatUtil;
import com.xh.study.bcy.utils.ToastUtil;
import com.xh.study.bcy.widget.FocusButton;
import com.xh.study.bcy.widget.StateLayout;
import com.xh.study.bcy.widget.TagView;
import com.xh.study.bcy.widget.stickheader.IpmlScrollChangListener;
import com.xh.study.bcy.widget.stickheader.StickHeaderLayout;
import com.xh.study.bcy.widget.tablayout.XTabLayout;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xh on 27/05/2018.
 * 可以滑动的Person视图
 */

public class SmoothPersonActivity extends BaseLoadingActivity<SmoothMvp.View, SmoothPersonPresenter> implements SmoothMvp.View<UserBean> {
    @BindView(R.id.person_viewpager)
    ViewPager personViewpager;
    @BindView(R.id.tablayout)
    XTabLayout tabLayout;
    @BindView(R.id.fold_header)
    StickHeaderLayout mStickHeaderLayout;
    @BindView(R.id.base_progressbar)
    StateLayout mBaseProgressbar;
    @BindView(R.id.private_split)
    View privateSplit;
    @BindView(R.id.circle_action_color)
    View circleActionColor;

    @BindView(R.id.person_bg)
    ImageView personBg;
    @BindView(R.id.base_action_bar_title)
    TextView baseActionBarTitle;
    @BindView(R.id.left_block)
    View leftBlock;
    @BindView(R.id.person_head_img)
    CircleImageView personHeadImg;
    @BindView(R.id.iv_gouda)
    FocusButton ivGouda;
    @BindView(R.id.iv_edit_material)
    FocusButton ivEditMaterial;
    @BindView(R.id.iv_attention)
    FocusButton ivAttention;
    @BindView(R.id.iv_attentioned)
    FocusButton ivAttentioned;
    @BindView(R.id.iv_gender)
    ImageView ivGender;
    @BindView(R.id.person_name_tv)
    TextView personNameTv;
    @BindView(R.id.tv_info)
    TextView tvInfo;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.person_care_tv)
    TextView personCareTv;
    @BindView(R.id.person_fans_tv)
    TextView personFansTv;
    @BindView(R.id.getzan_tv)
    TextView getzanTv;
    @BindView(R.id.no_roles_name)
    TextView noRolesName;
    @BindView(R.id.tv_role)
    TagView tvRole;

    public static void launch(Context context) {
        Intent intent = new Intent(context, SmoothPersonActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int layout() {
        return R.layout.activity_smooth_person;
    }

    Fragment[] fragments = new Fragment[2];
    int currentPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personViewpager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        fragments[0] = UserPostFragment.newInstance();
                        break;
                    case 1:
                        fragments[1] = UserPostFragment.newInstance();
                        break;
                }
                currentPosition = position;
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }

            final String titles[] = getResources().getStringArray(R.array.person_detail);

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        tabLayout.setupWithViewPager(personViewpager);
        personViewpager.setCurrentItem(0);


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
                circleActionColor.setAlpha((float) dy / totallDy);
                if(dy==totallDy){
                    baseActionBarTitle.setVisibility(View.VISIBLE);
                    leftBlock.setVisibility(View.VISIBLE);
                }else {
                    if(baseActionBarTitle.getVisibility()!=View.GONE) baseActionBarTitle.setVisibility(View.GONE);
                    if(leftBlock.getVisibility()!=View.GONE) leftBlock.setVisibility(View.GONE);
                }
            }
        });
        getPresenter().loadData();
    }

    @Override
    public void showProgress(int resId) {
        mBaseProgressbar.loadingProgress();
    }

    @Override
    public void updateUi(UserBean bean) {
        mBaseProgressbar.loadingHide();
        StatusBarUtil.setTranslucent(this);
        //privateSplit.getLayoutParams().height = (ViewHelper.getStatusBarHeight(this));
        //privateSplit.setVisibility(View.VISIBLE);
        //privateSplit.setFitsSystemWindows(false);
        //circleActionColor.setBackgroundColor(getResources().getColor(R.color.bar_color));

        Glide.with(this).load(bean.getAvatar_fat()).into(personBg);
        Glide.with(this).load(bean.getAvatar()).into(personHeadImg);
        baseActionBarTitle.setText(bean.getUname());
        ivEditMaterial.setVisibility(View.GONE);
        ivGouda.setText( getString(R.string.hang_up_unit, FormatUtil.formatNum(this,bean.getAnswer_count() )));
        ivGouda.setBeforeDoCallBack(()->{
            ToastUtil.custom(this,"focus before action and return false",1).show();
            return false;
        });
        if(bean.getUtags()!=null) {
            tvRole.addUTags(bean.getUtags());
            noRolesName.setVisibility(View.GONE);
        }
        if(bean.getFollowstate().equals("havefollow")){
            ivAttention.setVisibility(View.VISIBLE);
        }else {
            ivAttentioned.setVisibility(View.VISIBLE);
        }
        personNameTv.setText(bean.getUname());
        if(bean.getSex().equals("1")){
            ivGender.setImageResource(R.drawable.profile_boy);
        }else if(bean.getSex().equals("0")){
            ivGender.setImageResource(R.drawable.profile_girl);
        }
        tvInfo.setText(bean.getSelf_intro());
        tvAddress.setText(bean.getLocation());
        personCareTv.setText(FormatUtil.formatNum(this,bean.getFollowing()));
        personFansTv.setText(FormatUtil.formatNum(this,bean.getFollower()));
        getzanTv.setText(FormatUtil.formatNum(this,bean.getDing_count()));

    }

    @Override
    protected boolean canBack() {
        return false;
    }

    @NonNull
    @Override
    public SmoothPersonPresenter providePresenter() {
        return new SmoothPersonPresenter();
    }

}
