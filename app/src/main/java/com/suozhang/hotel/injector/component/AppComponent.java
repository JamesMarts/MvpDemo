package com.suozhang.hotel.injector.component;

import com.suozhang.hotel.injector.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by LIJUWEN on 2017/3/14.
 */
@Singleton
@Component(modules = AppModule.class)
public class AppComponent {

}
