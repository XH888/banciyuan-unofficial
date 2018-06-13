package com.xh.study.bcy.ui.main;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.evernote.android.state.State;
import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseActivity;
import com.xh.study.bcy.ui.base.loading.BaseLoadingFragment;
import com.xh.study.bcy.ui.main.mainpage.MainPageFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xh on 04/02/2018.
 */

public class MainActivity extends BaseActivity<MainMvp.View,MainPresenter> implements MainMvp.View {

    @State
    @MainMvp.NavigationType int navType = MainMvp.MAINPAGE;//保存当前button index

    @BindView(R.id.main_bottom_lly)
    LinearLayout mainBottomLLY;

    @BindView( R.id.main_bottom_mainpage_tv)
    ImageView mainpageIv;
    @BindView(R.id.main_bottom_discover_tv)
    ImageView discoverIv;
    @BindView(R.id.main_bottom_post)
    ImageView postIv;
    @BindView(R.id.main_bottom_group_tv)
    ImageView groupIv;
    @BindView(R.id.main_bottom_mine_tv)
    ImageView mineIv;

    public static void launch(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected int layout() {
        return R.layout.main_layout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState==null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content_fly, MainPageFragment.newInstance(), MainPageFragment.TAG)
                .commit();
        }
        onButtomClick(navType);
    }

    public void onButtomClick(int type) {
        onButtomClick((ImageView) mainBottomLLY.getChildAt(type));
    }

    @OnClick({R.id.main_bottom_mainpage_tv,R.id.main_bottom_discover_tv,R.id.main_bottom_post,R.id.main_bottom_group_tv,R.id.main_bottom_mine_tv})
    public void onButtomClick(ImageView view){
        int type = mainBottomLLY.indexOfChild(view);

        mainpageIv.setImageResource(R.drawable.main_mainpage_black);
        discoverIv.setImageResource(R.drawable.main_discover_black);
        groupIv.setImageResource(R.drawable.main_group_black);
        postIv.setImageResource(R.drawable.main_post);
        mineIv.setImageResource(R.drawable.main_mine_black);
        switch (type){
            case MainMvp.MAINPAGE:
                view.setImageResource(R.drawable.main_mainpage_pink);
                break;
            case MainMvp.DISCOVER:
                view.setImageResource(R.drawable.main_discover_pink);
                break;
            case MainMvp.POST:
                view.setImageResource(R.drawable.main_post);
                break;
            case MainMvp.GROUP:
                view.setImageResource(R.drawable.main_group_pink);
                break;
            case MainMvp.MINE:
                view.setImageResource(R.drawable.main_mine_pink);
                break;
        }
        onNavigationChanged(type);
    }


    BaseLoadingFragment currentLoadingFragment;

    public void setCurrentLoadingFragment(BaseLoadingFragment currentLoadingFragment) {
        this.currentLoadingFragment = currentLoadingFragment;
    }

    @Override
    public void onNavigationChanged(int type) {
        if (navType == type){
            //current loading fragment refresh
            if(currentLoadingFragment!=null)
                currentLoadingFragment.onNavigateClick();
        } else {
            getPresenter().onModuleChanged(getSupportFragmentManager(),type);
            navType = type;
        }
    }

    @Override
    protected boolean canBack() {
        return false;
    }

    @NonNull
    @Override
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }

}
