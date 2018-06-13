package com.xh.study.bcy.ui.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.mvp.presenter.BasePresenter;
import com.xh.study.bcy.ui.main.discover.DiscoverFragment;
import com.xh.study.bcy.ui.main.group.GroupFragment;
import com.xh.study.bcy.ui.main.mainpage.MainPageFragment;
import com.xh.study.bcy.ui.main.mine.MineFragment;
import com.xh.study.bcy.ui.main.post.PostFragment;
import com.xh.study.bcy.utils.AppHelper;


/**
 * Created by xh on 25/04/2018.
 */

public class MainPresenter extends BasePresenter<MainMvp.View> implements MainMvp.Presenter{

    @Override
    public void onShowHideFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment toShow, @NonNull Fragment toHide) {
        toHide.onHiddenChanged(true);
        fragmentManager
                .beginTransaction()
                .hide(toHide)
                .show(toShow)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        toShow.onHiddenChanged(false);
    }

    @Override
    public void onAddAndHide(@NonNull FragmentManager fragmentManager, @NonNull Fragment toAdd, @NonNull Fragment toHide) {
        toHide.onHiddenChanged(true);
        fragmentManager
                .beginTransaction()
                .hide(toHide)
                .add(R.id.main_content_fly, toAdd, toAdd.getClass().getSimpleName())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        toAdd.onHiddenChanged(false);
    }

    @Override  @SuppressWarnings("ConstantConditions")
    public void onModuleChanged(@NonNull FragmentManager fragmentManager,@MainMvp.NavigationType int type) {
        Fragment currentVisibleFragment = AppHelper.getVisibleFragment(fragmentManager);

        MainPageFragment mainPageFragment =(MainPageFragment)AppHelper.getFragmentByTag(fragmentManager, MainPageFragment.TAG);
        DiscoverFragment discoverFragment = (DiscoverFragment)AppHelper.getFragmentByTag(fragmentManager, DiscoverFragment.TAG);
        PostFragment postFragment = (PostFragment)AppHelper.getFragmentByTag(fragmentManager, PostFragment.TAG);
        MineFragment mineFragment = (MineFragment)AppHelper.getFragmentByTag(fragmentManager, MineFragment.TAG);
        GroupFragment groupFragment = (GroupFragment)AppHelper.getFragmentByTag(fragmentManager, GroupFragment.TAG);
        switch (type){
            case MainMvp.MAINPAGE:
                if(mainPageFragment==null){
                    onAddAndHide(fragmentManager,MainPageFragment.newInstance(),currentVisibleFragment);
                }else {
                    onShowHideFragment(fragmentManager,mainPageFragment,currentVisibleFragment);
                }
                break;
            case MainMvp.DISCOVER:
                if(discoverFragment ==null){
                    onAddAndHide(fragmentManager, DiscoverFragment.newInstance(),currentVisibleFragment);
                }else {
                    onShowHideFragment(fragmentManager, discoverFragment,currentVisibleFragment);
                }
                break;
            case MainMvp.POST:
                if(postFragment ==null){
                    onAddAndHide(fragmentManager, PostFragment.newInstance(),currentVisibleFragment);
                }else {
                    onShowHideFragment(fragmentManager, postFragment,currentVisibleFragment);
                }
                break;
            case MainMvp.GROUP:
                if(groupFragment ==null){
                    onAddAndHide(fragmentManager, GroupFragment.newInstance(),currentVisibleFragment);
                }else {
                    onShowHideFragment(fragmentManager, groupFragment,currentVisibleFragment);
                }
                break;
            case MainMvp.MINE:
                if(mineFragment ==null){
                    onAddAndHide(fragmentManager, MineFragment.newInstance(),currentVisibleFragment);
                }else {
                    onShowHideFragment(fragmentManager, mineFragment,currentVisibleFragment);
                }
                break;
        }
    }

}
