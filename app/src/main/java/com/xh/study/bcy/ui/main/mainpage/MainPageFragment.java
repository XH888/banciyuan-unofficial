package com.xh.study.bcy.ui.main.mainpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseFragment;
import com.xh.study.bcy.ui.main.mainpage.pager.BangumiFragment;
import com.xh.study.bcy.ui.main.mainpage.pager.CircleFragment;
import com.xh.study.bcy.ui.main.mainpage.pager.FriendFeedFragment;
import com.xh.study.bcy.ui.main.mainpage.pager.TimeLineFragment;
import com.xh.study.bcy.widget.tablayout.XTabLayout;


import butterknife.BindView;

/**
 * Created by xh on 10/02/2018.
 */

public class MainPageFragment extends BaseFragment<MainPageMvp.View, MainPagePresenter> implements MainPageMvp.View {
    public static final String TAG = MainPageFragment.class.getSimpleName();

    @BindView(R.id.tablayout)
    XTabLayout mBcyTabLayout;
    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.view_login)
    FrameLayout viewLogin;

    public static MainPageFragment newInstance() {
        return new MainPageFragment();
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.mainpage_layout;
    }

    Fragment[] fragments = new Fragment[4];

    @Override
    protected void onFragmentCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (fragments[position] == null) {
                    switch (position) {
                        case 0:
                            fragments[0] = FriendFeedFragment.newInstance();
                            break;
                        case 1:
                            fragments[1] = TimeLineFragment.newInstance();
                            break;
                        case 2:
                            fragments[2] = BangumiFragment.newInstance();
                            break;
                        case 3:
                            fragments[3] = CircleFragment.newInstance();
                            break;
                    }
                }
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
            final String titles[] = getResources().getStringArray(R.array.mainpage_tab);

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mBcyTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(1);
        mViewPager.setOffscreenPageLimit(fragments.length);
    }

    @NonNull
    @Override
    public MainPagePresenter providePresenter() {
        return new MainPagePresenter();
    }

}
