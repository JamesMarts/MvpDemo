package com.suozhang.hotel.injector.component;

import android.content.Context;

import com.suozhang.hotel.injector.module.AppModule;
import com.suozhang.hotel.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LIJUWEN on 2017/3/14.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    // provide
    Context getContext();

    RxBus getRxBus();

//    DaoSession getDaoSession();


}
