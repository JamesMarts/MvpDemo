package com.suozhang.hotel.moudle.newss.newslist;

import android.os.Bundle;

import com.suozhang.hotel.adapter.NewsMultiItem;
import com.suozhang.hotel.api.bean.NewsInfo;
import com.suozhang.hotel.moudle.base.BaseFragment;
import com.suozhang.hotel.moudle.base.IBasePresenter;

import java.util.List;


public class NewsListFragment extends BaseFragment<IBasePresenter> implements INewsListView {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void loadData(List<NewsMultiItem> data) {

    }

    @Override
    public void loadMoreData(List<NewsMultiItem> data) {

    }

    @Override
    public void loadNoData() {

    }

    @Override
    public void loadNewsData(NewsInfo newsInfo) {

    }


    @Override
    protected int attachLayoutRes() {
        return 0;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews() {

    }
}
