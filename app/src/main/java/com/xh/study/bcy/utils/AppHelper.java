package com.xh.study.bcy.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * Created by xh on 23/04/2018.
 */

public class AppHelper {

    @Nullable
    public static Fragment getFragmentByTag(@NonNull FragmentManager fragmentManager, @NonNull String tag) {
        return fragmentManager.findFragmentByTag(tag);
    }

    /**
     * 取得当前管理器可见的Fragment
     * @param fragmentManager
     * @return
     */
    @Nullable
    public static Fragment getVisibleFragment(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if(fragments!=null&&!fragments.isEmpty()){
            for (Fragment fragment:fragments) {
                if(fragment!=null&&fragment.isVisible()){
                    return fragment;
                }
            }
        }
        return null;
    }
}
