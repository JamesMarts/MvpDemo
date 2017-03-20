package com.suozhang.hotel.injector.component;

import com.suozhang.hotel.injector.FragmentScope;
import com.suozhang.hotel.injector.module.NewsMainModule;
import com.suozhang.hotel.moudle.news.main.NewsMainFragment;

import dagger.Component;

/**
 * Created by LIJUWEN on 2017/3/20.
 * 新闻主页
 */

@FragmentScope
@Component(dependencies = AppComponent.class,modules = NewsMainModule.class)
public interface NewsMainComponent {
    void inject(NewsMainFragment newsMainFragment);
}
