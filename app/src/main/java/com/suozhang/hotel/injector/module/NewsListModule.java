package com.suozhang.hotel.injector.module;

import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.suozhang.hotel.adapter.NewsMultListAdapter;
import com.suozhang.hotel.injector.FragmentScope;
import com.suozhang.hotel.moudle.base.IBasePresenter;
import com.suozhang.hotel.moudle.news.list.NewsListFragment;
import com.suozhang.hotel.moudle.news.list.NewsListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by LIJUWEN on 2017/3/22.
 */
@Module
public class NewsListModule {
    private NewsListFragment newsListFragment;
    private String newsId;

    public NewsListModule(NewsListFragment newsListFragment, String newsId) {
        this.newsListFragment = newsListFragment;
        this.newsId = newsId;
    }

    @FragmentScope
    @Provides
    public IBasePresenter providerPresenter() {
        return new NewsListPresenter();
    }

    @FragmentScope
    @Provides
    public BaseQuickAdapter prividerAdapter(){

        return new NewsMultListAdapter(null);
    }
}
