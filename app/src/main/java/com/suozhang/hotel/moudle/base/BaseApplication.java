package com.suozhang.hotel.moudle.base;

import android.app.Application;

import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by LIJUWEN on 2017/3/13.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initConfig();
    }
    private void initConfig(){
        //初始化Logger
        Logger.init("SZ_TAG");
        //内存泄漏管理器
        LeakCanary.install(this);

    }

}
