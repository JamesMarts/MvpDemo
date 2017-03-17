package com.suozhang.hotel.injector.component;

import android.app.Activity;

/**
 * Created by LIJUWEN on 2017/3/14.
 */
//@Singleton
//@Component(dependencies = ActivityComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

}
