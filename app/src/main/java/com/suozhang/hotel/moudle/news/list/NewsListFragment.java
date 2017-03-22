package com.suozhang.hotel.moudle.news.list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.dl7.recycler.adapter.BaseQuickAdapter;
import com.dl7.recycler.helper.RecyclerViewHelper;
import com.dl7.recycler.listener.OnRequestDataListener;
import com.suozhang.hotel.R;
import com.suozhang.hotel.adapter.NewsMultiItem;
import com.suozhang.hotel.api.bean.NewsInfo;
import com.suozhang.hotel.injector.component.DaggerNewsListComponent;
import com.suozhang.hotel.injector.module.NewsListModule;
import com.suozhang.hotel.moudle.base.BaseFragment;
import com.suozhang.hotel.moudle.base.IBasePresenter;
import com.suozhang.hotel.widget.EmptyLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;


public class NewsListFragment extends BaseFragment<IBasePresenter> implements INewsListView {
    private static final String NEWS_TYPE_KEY = "NewsTypeKey";

    @BindView(R.id.rv_news_list)
    RecyclerView mRvNewsList;
    @BindView(R.id.empty_layout)
    EmptyLayout mEmptyLayout;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    @Inject
    BaseQuickAdapter mAdapter;

    private String mNewsId;

    private SliderLayout mSliderLayout;

    public static NewsListFragment getInstance(String title) {
        NewsListFragment newsListFragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NEWS_TYPE_KEY, title);
        newsListFragment.setArguments(bundle);
        return newsListFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNewsId = getArguments().getString(NEWS_TYPE_KEY);

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mSliderLayout != null) {
            mSliderLayout.startAutoCycle();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mSliderLayout != null) {
            mSliderLayout.stopAutoCycle();
        }
    }

    @Override
    public void loadData(List<NewsMultiItem> data) {
        mAdapter.updateItems(data);
    }

    @Override
    public void loadMoreData(List<NewsMultiItem> data) {
        mAdapter.loadComplete();
        mAdapter.addItem(data);

    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }



    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void initInjector() {
        DaggerNewsListComponent.builder().appComponent(getAppComponent()).
                newsListModule(new NewsListModule(this, mNewsId)).
                build().inject(this);
    }

    @Override
    protected void initViews() {
        SlideInRightAnimationAdapter animationAdapter = new SlideInRightAnimationAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewV(mContext, mRvNewsList, true, new AlphaInAnimationAdapter(animationAdapter));
        mAdapter.setRequestDataListener(new OnRequestDataListener() {
            @Override
            public void onLoadMore() {
                mPresenter.getData();
            }
        });
    }

    @Override
    protected void updateViews() {
        mPresenter.getData();
    }


    @Override
    public void loadNewsData(NewsInfo newsInfo) {

    }
}
