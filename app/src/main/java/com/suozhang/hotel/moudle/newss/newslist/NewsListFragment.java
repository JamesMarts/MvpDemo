package com.suozhang.hotel.moudle.newss.newslist;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suozhang.hotel.R;
import com.suozhang.hotel.adapter.NewsMultiItem;
import com.suozhang.hotel.api.bean.NewsInfo;
import com.suozhang.hotel.moudle.base.BaseFragment;
import com.suozhang.hotel.moudle.base.IBasePresenter;
import com.suozhang.hotel.widget.EmptyLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsListFragment extends BaseFragment<IBasePresenter> implements INewsListView {


    @BindView(R.id.rv_news_list)
    RecyclerView mRvNewsList;
    @BindView(R.id.empty_layout)
    EmptyLayout mEmptyLayout;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

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
        return R.layout.fragment_news_list;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
