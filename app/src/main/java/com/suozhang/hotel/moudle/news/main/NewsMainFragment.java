package com.suozhang.hotel.moudle.news.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.suozhang.hotel.R;
import com.suozhang.hotel.adapter.ViewPagerAdapter;
import com.suozhang.hotel.injector.component.DaggerNewsMainComponent;
import com.suozhang.hotel.injector.module.NewsMainModule;
import com.suozhang.hotel.local.table.NewsTypeInfo;
import com.suozhang.hotel.moudle.base.BaseFragment;
import com.suozhang.hotel.moudle.base.IRxBusPresenter;
import com.suozhang.hotel.moudle.news.list.NewsListFragment;
import com.suozhang.hotel.rxbus.event.ChannelEvent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import rx.functions.Action1;


public class NewsMainFragment extends BaseFragment<IRxBusPresenter> implements INewsMainView {


    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @Inject
    ViewPagerAdapter mPagerAdapter;

    @Override
    public void loadData(List<NewsTypeInfo> checkList) {
        List<Fragment> fragments = new ArrayList<>();
        List<String> title = new ArrayList<>();
        for (NewsTypeInfo n : checkList) {
            fragments.add(NewsListFragment.getInstance(n.getTypeId()));
            title.add(n.getName());
        }

        mPagerAdapter.setItem(title, fragments);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_main;
    }

    @Override
    protected void initInjector() {
        DaggerNewsMainComponent.builder()
                .appComponent(getAppComponent())
                .newsMainModule(new NewsMainModule(this))
                .build().inject(this);

    }

    @Override
    protected void initViews() {
        //initToorBar(mToolBar, true, "新闻");
        setHasOptionsMenu(true);

        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mPresenter.registerRxBus(ChannelEvent.class, new Action1<ChannelEvent>() {
            @Override
            public void call(ChannelEvent channelEvent) {
                handleChannelEvent(channelEvent);
            }
        });
    }

    @Override
    protected void updateViews() {
        mPresenter.getData();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


    }

    private void handleChannelEvent(ChannelEvent channelEvent) {
        switch (channelEvent.eventType) {
            case ChannelEvent.ADD_EVENT:
                mPagerAdapter.addItem(channelEvent.newsInfo.getName(), NewsListFragment.getInstance(channelEvent.newsInfo.getTypeId()));
                break;
            case ChannelEvent.DEL_EVENT:
                mViewPager.setCurrentItem(0);
                mPagerAdapter.delItem(channelEvent.newsInfo.getName());
                break;
            case ChannelEvent.SWAP_EVENT:
                mPagerAdapter.changeItem(channelEvent.fromPos, channelEvent.toPos);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unRegisterRxBus();
    }
}
