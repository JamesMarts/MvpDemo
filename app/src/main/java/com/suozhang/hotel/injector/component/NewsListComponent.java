package com.suozhang.hotel.injector.component;

import com.suozhang.hotel.injector.FragmentScope;
import com.suozhang.hotel.injector.module.NewsListModule;
import com.suozhang.hotel.moudle.news.list.NewsListFragment;

import dagger.Component;

/**
 * Created by LIJUWEN on 2017/3/22.
 */

@FragmentScope
@Component(dependencies = AppComponent.class,modules = NewsListModule.class)
public interface NewsListComponent {
    void inject(NewsListFragment newsListFragment);
}
