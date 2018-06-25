package com.xh.study.bcy.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.base.BaseActivity;
import com.xh.study.bcy.ui.main.MainActivity;
import com.xh.study.bcy.utils.AppHelper;
import com.xh.study.bcy.utils.PreferencesUtil;
import com.xh.study.bcy.utils.ToastUtil;
import com.xh.study.bcy.widget.PopWaitFragment;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by XH on 2018/1/30.
 */

public class LoginActivity extends BaseActivity<LoginMvp.View,LoginPresenter> implements LoginMvp.View{

    @BindView(R.id.iv_cancel)
    ImageView cancelImage;
    @BindView(R.id.start_logo_img)
    ImageView startLogoImage;
    @BindView(R.id.login_email_edt)
    EditText loginEdit;
    @BindView(R.id.login_pass_edt)
    EditText passEdit;
    @BindView(R.id.tv_login)
    TextView loginTv;

    public static void launch(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int layout() {
        return R.layout.login_layout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginEdit.setText(PreferencesUtil.getString(this,KEY_USERNAME));
        loginEdit.setOnFocusChangeListener((v,hasFocus)-> startLogoImage.setImageResource(R.drawable.login_back));
        passEdit.setOnFocusChangeListener((v, hasFocus)-> startLogoImage.setImageResource(R.drawable.login_back_hidden));
        loginTv.setOnClickListener(v->getPresenter().login(loginEdit.getText().toString(), passEdit.getText().toString()));
    }

    @Override
    protected boolean canBack() {
        return false;
    }

    @Override
    protected void onPause() {
        PreferencesUtil.putString(this,KEY_USERNAME,loginEdit.getText().toString());
        super.onPause();
    }

    @NonNull
    @Override
    public LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onEmpty() {
        ToastUtil.custom(this,R.string.login_error_null,0).show();
    }

    @Override
    public void onSuccessfullyLoggedIn() {
        hideProgress();
        MainActivity.launch(LoginActivity.this);
        PreferencesUtil.putBoolean(this,BaseActivity.IS_LOGIN,true);
        overridePendingTransition(R.anim.base_fade_in,  R.anim.base_fade_out);
        finish();
    }

    @Override
    public void showProgress(int resId) {
        PopWaitFragment fragment = (PopWaitFragment) AppHelper.getFragmentByTag(getSupportFragmentManager(),PopWaitFragment.TAG);
        if(!isProgressShowing && !isFinishing()){
            if (fragment == null) {
                isProgressShowing = true;
                fragment = PopWaitFragment.newInstance( );
                fragment.show(getSupportFragmentManager(), PopWaitFragment.TAG);
            }
        }
    }

    @Override
    public void hideProgress() {
        PopWaitFragment fragment = (PopWaitFragment) AppHelper.getFragmentByTag(getSupportFragmentManager(),PopWaitFragment.TAG);
        if(fragment!=null){
            isProgressShowing = false;
            fragment.dismiss();
        }
    }

    @Override
    public void showError(@NonNull String errorMsg) {
        ToastUtil.custom(this,errorMsg,1).show();
    }

    @OnClick(R.id.iv_cancel)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MainActivity.launch(this);
        overridePendingTransition(R.anim.base_fade_in,  R.anim.base_fade_out);
        finish();
    }

}
