package com.suozhang.hotel.injector.module;

import android.content.Context;

import com.suozhang.hotel.MvpApplication;
import com.suozhang.hotel.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LIJUWEN on 2017/3/14.
 */
@Module
public class AppModule {
    private final MvpApplication mApplication;
    private final RxBus mRxBus;

    public AppModule(MvpApplication application,  RxBus rxBus) {
        mApplication = application;
        mRxBus = rxBus;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return mRxBus;
    }


}
