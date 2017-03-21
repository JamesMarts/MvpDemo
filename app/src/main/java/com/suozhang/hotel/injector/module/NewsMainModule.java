package com.suozhang.hotel.injector.module;

import com.suozhang.hotel.adapter.ViewPagerAdapter;
import com.suozhang.hotel.injector.FragmentScope;
import com.suozhang.hotel.moudle.base.IRxBusPresenter;
import com.suozhang.hotel.moudle.news.main.NewsMainFragment;
import com.suozhang.hotel.moudle.news.main.NewsMainPresenter;
import com.suozhang.hotel.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LIJUWEN on 2017/3/20.
 */
@Module
public class NewsMainModule {
    private NewsMainFragment mView;

    public NewsMainModule(NewsMainFragment mView) {
        this.mView = mView;
    }


    @FragmentScope
    @Provides
    public IRxBusPresenter provideIRxBusPresenter(RxBus rxBus) {
        return new NewsMainPresenter(mView,null,  rxBus);
    }

    @FragmentScope
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }
}
