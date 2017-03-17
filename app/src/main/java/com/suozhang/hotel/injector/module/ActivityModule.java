package com.suozhang.hotel.injector.module;

import android.app.Activity;

import com.suozhang.hotel.injector.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LIJUWEN on 2017/3/14.
 */
@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @ActivityScope
    @Provides
    Activity getActivity() {
        return mActivity;
    }
}
