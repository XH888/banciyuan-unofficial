package com.xh.study.bcy;

import android.app.Application;

import com.xh.study.bcy.adapter.model.DaoMaster;
import com.xh.study.bcy.adapter.model.DaoSession;


/**
 * Created by XH on 2018/1/29.
 */

public class App extends Application {

    private static App mInstance;
    private static final String DB_NAME = "app_db";

    private DaoSession mDaoSession;

    public static App getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        deleteDatabase("database.db");
        initDB();
    }

    private void initDB() {
        if(mDaoSession==null) {
            DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(this, DB_NAME, null);
            mDaoSession = new DaoMaster(mHelper.getWritableDatabase()).newSession();
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

}
