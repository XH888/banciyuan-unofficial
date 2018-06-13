package com.xh.study.bcy.ui.main.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseFragment;
import com.xh.study.bcy.ui.main.mainpage.MainPageMvp;
import com.xh.study.bcy.ui.main.mainpage.MainPagePresenter;
import com.xh.study.bcy.widget.tablayout.XTabLayout;

import butterknife.BindView;

/**
 * Created by xh on 10/02/2018.
 */

public class MineFragment extends BaseFragment<MainPageMvp.View, MainPagePresenter> implements MainPageMvp.View {
    public static final String TAG = MineFragment.class.getSimpleName();

    @BindView(R.id.tablayout)
   XTabLayout mTabLayout;
    @BindView(R.id.pager)
    ViewPager mViewPager;
    @BindView(R.id.view_login)
    TextView login;

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.mainpage_layout;
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
                            //fragments[0] = AttentionFragment.newInstance();
                            break;
                        case 1:
                            //fragments[1] = HomeFragment.newInstance();
                            break;
                        case 2:
                            //fragments[2] = CircleFragment.newInstance();
                            break;
                    }
                }
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
            final String titles[] = {
                    MineFragment.this.getString(R.string.focus),
                    MineFragment.this.getString(R.string.index_unit),
                    MineFragment.this.getString(R.string.circle)
            };

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(1);
        mViewPager.setOffscreenPageLimit(fragments.length);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public MainPagePresenter providePresenter() {
        return new MainPagePresenter();
    }

}
