package com.suozhang.hotel.moudle.news.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.suozhang.hotel.R;
import com.suozhang.hotel.adapter.ViewPagerAdapter;
import com.suozhang.hotel.local.table.NewsTypeInfo;
import com.suozhang.hotel.moudle.base.BaseFragment;
import com.suozhang.hotel.moudle.base.IRxBusPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


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

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initToorBar(mToolBar, true, "新闻");
        setHasOptionsMenu(true);
    }

    @Override
    protected void updateViews() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
