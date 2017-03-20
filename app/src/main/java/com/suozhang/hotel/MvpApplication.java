package com.suozhang.hotel;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.suozhang.hotel.injector.component.AppComponent;
import com.suozhang.hotel.injector.component.DaggerAppComponent;
import com.suozhang.hotel.injector.module.AppModule;
import com.suozhang.hotel.rxbus.RxBus;

/**
 * Created by LIJUWEN on 2017/3/13.
 */

public class MvpApplication extends Application {
    private static final String DB_NAME = "news-db";

    private AppComponent mAppComponent;
    private static Context sContext;
    // 因为下载那边需要用，这里在外面实例化在通过 ApplicationModule 设置
    private RxBus mRxBus = new RxBus();

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        _initInjector();
        _initConfig();
    }


    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static Context getContext() {
        return sContext;
    }

    /**
     * 初始化注射器
     */
    private void _initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this, mRxBus)).build();
    }


    /**
     * 初始化配置
     */
    private void _initConfig() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
            Logger.init("LogTAG");
        }
//        RetrofitService.init();
    }

}
