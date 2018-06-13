package com.xh.study.bcy.ui.main.discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseFragment;
import com.xh.study.bcy.ui.main.discover.pager.IllustFragment;
import com.xh.study.bcy.ui.main.mainpage.MainPageMvp;
import com.xh.study.bcy.ui.main.mainpage.MainPagePresenter;
import com.xh.study.bcy.widget.tablayout.XTabLayout;

import butterknife.BindView;

/**
 * Created by xh on 10/02/2018.
 */

public class DiscoverFragment extends BaseFragment<DiscoverMvp.View, DiscoverPresenter> implements DiscoverMvp.View {
    public static final String TAG = DiscoverFragment.class.getSimpleName();

    @BindView(R.id.tablayout)
    XTabLayout mTabLayout;
    @BindView(R.id.daily_pager)
    ViewPager mViewPager;
    @BindView(R.id.view_login)
    TextView login;

    public static DiscoverFragment newInstance() {
        return new DiscoverFragment();
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.discover_fragment;
    }

    Fragment[] fragments = new Fragment[3];

    @Override
    protected void onFragmentCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (fragments[position] == null) {
                    switch (position) {
                        case 0:
                            fragments[0] = IllustFragment.newInstance();
                            break;
                        case 1:
                            fragments[1] = IllustFragment.newInstance();
                            break;
                        case 2:
                            fragments[2] = IllustFragment.newInstance();
                            break;
                    }
                }
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
            final String titles[] = getResources().getStringArray(R.array.discover_tab);

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(fragments.length);
    }


    @NonNull
    @Override
    public DiscoverPresenter providePresenter() {
        return new DiscoverPresenter();
    }

}
