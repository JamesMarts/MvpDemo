package com.suozhang.hotel.moudle.news.main;

import com.orhanobut.logger.Logger;
import com.suozhang.hotel.local.table.NewsTypeInfo;
import com.suozhang.hotel.local.table.NewsTypeInfoDao;
import com.suozhang.hotel.moudle.base.IRxBusPresenter;
import com.suozhang.hotel.rxbus.RxBus;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by LIJUWEN on 2017/3/20.
 */

public class NewsMainPresenter implements IRxBusPresenter {

    private final INewsMainView mView;
    private final NewsTypeInfoDao mDbDao;
    private final RxBus mRxBus;

    public NewsMainPresenter(INewsMainView view, NewsTypeInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
        mRxBus = rxBus;
    }


    @Override
    public void getData() {
        mDbDao.queryBuilder().rx().list().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<NewsTypeInfo>>() {
            @Override
            public void call(List<NewsTypeInfo> newsTypeInfos) {
                mView.loadData(newsTypeInfos);
            }
        });

    }

    @Override
    public void getMoreData() {

    }

    @Override
    public <T> void registerRxBus(Class<T> eventType, Action1<T> action) {
        Subscription subscription = mRxBus.doSubscribe(eventType, action, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.e(throwable.toString());
            }
        });

        mRxBus.addSubscription(this, subscription);
    }

    @Override
    public void unRegisterRxBus() {
        mRxBus.unSubscribe(this);
    }
}
