package com.xh.study.bcy.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.xh.study.bcy.R;
import com.xh.study.bcy.ui.login.LoginActivity;
import com.xh.study.bcy.ui.main.MainActivity;
import com.xh.study.bcy.utils.PreferencesUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends Activity{
    Disposable disposable ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);

        ImageView backgroundIv = findViewById(R.id.background);
        backgroundIv.setImageResource(R.drawable.loading_default);
        TextView skipTv = findViewById(R.id.tv_skip);
        skipTv.setOnClickListener(l-> jumpActivity());
        disposable =  Observable.interval(1,TimeUnit.SECONDS).take(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(sec ->  skipTv.setText((sec+1) +"s 跳过"),
                        Throwable::printStackTrace,
                        this::jumpActivity);

//        disposable =RestProvider.createApi(API.class).getStartCover()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .flatMap(new Function<BaseEntity<StartCoverBean>, ObservableSource<Long>>() {
//                    @Override
//                    public ObservableSource<Long> apply(BaseEntity<StartCoverBean> startCoverBeanBaseEntity) throws Exception {
//                        if(!TextUtils.isEmpty( startCoverBeanBaseEntity.getItems().getStart_cover() )) {
//                            Glide.with(SplashActivity.this)
//                                    .loadData(startCoverBeanBaseEntity.getItems().getStart_cover())
//                                    .downloadOnly(backgroundIv.getWidth(), backgroundIv.getHeight())
//                                    .get();
//                        }
//                        backgroundIv.setImageResource(R.drawable.loading_default);
//                        skipTv.setVisibility(View.VISIBLE);
//                        return Observable.timer(3, TimeUnit.SECONDS);
//                    }
//            })
//            .subscribe(aLong ->{
//                    jumpActivity();
//                }
//            );
    }

    void jumpActivity(){
        if(disposable!=null && !disposable.isDisposed()){
            disposable.dispose();
        }
        if(PreferencesUtil.getIsLogin(SplashActivity.this)){
            MainActivity.launch(this);
        }else {
            LoginActivity.launch(this);
        }
        finish();
        overridePendingTransition(R.anim.base_fade_in,  R.anim.base_fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!disposable.isDisposed())
            disposable.dispose();
    }
}