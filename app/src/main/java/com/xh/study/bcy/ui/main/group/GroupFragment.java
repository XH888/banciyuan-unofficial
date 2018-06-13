package com.xh.study.bcy.ui.main.group;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseFragment;
import com.xh.study.bcy.ui.main.group.pager.GroupCommonFragment;
import com.xh.study.bcy.ui.main.group.pager.HotGroupFragment;
import com.xh.study.bcy.ui.main.mainpage.MainPageMvp;
import com.xh.study.bcy.ui.main.mainpage.MainPagePresenter;
import com.xh.study.bcy.widget.tablayout.XTabLayout;

import butterknife.BindView;

/**
 * Created by xh on 10/02/2018.
 */

public class GroupFragment extends BaseFragment<GroupMvp.View, GroupPresenter> implements GroupMvp.View {
    public static final String TAG = GroupFragment.class.getSimpleName();

    @BindView(R.id.group_tablayout)
    XTabLayout mTabLayout;
    @BindView(R.id.team_pager)
    ViewPager mViewPager;

    @BindView(R.id.search)
    LinearLayout search;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.view_login)
    TextView login;



    public static GroupFragment newInstance() {
        return new GroupFragment();
    }

    @Override
    protected int fragmentLayout() {
        return R.layout.team_layout;
    }

    //原本这里的Page数量是从网络返回的。我方便直接写死。
    Fragment[] fragments = new Fragment[5];

    @Override
    protected void onFragmentCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (fragments[position] == null) {
                    switch (position) {
                        case 0:
                            fragments[0] = HotGroupFragment.newInstance();
                            break;
                        case 1:
                            //下面的几个GroupCommonFragment 实际上是一个地址。只是传参不一样。
                            fragments[1] = GroupCommonFragment.newInstance();
                            break;
                        case 2:
                            fragments[2] = GroupCommonFragment.newInstance();
                            break;
                        case 3:
                            fragments[3] = GroupCommonFragment.newInstance();
                            break;
                        case 4:
                            fragments[4] = GroupCommonFragment.newInstance();
                            break;
                    }
                }
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
            final String titles[] = getResources().getStringArray(R.array.group_tab);

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(fragments.length);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public GroupPresenter providePresenter() {
        return new GroupPresenter();
    }

}
