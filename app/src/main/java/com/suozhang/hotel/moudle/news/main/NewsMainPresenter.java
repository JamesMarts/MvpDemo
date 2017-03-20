package com.suozhang.hotel.moudle.news.main;

import com.suozhang.hotel.local.table.NewsTypeInfoDao;
import com.suozhang.hotel.moudle.base.IRxBusPresenter;
import com.suozhang.hotel.rxbus.RxBus;

import rx.functions.Action1;

/**
 * Created by LIJUWEN on 2017/3/20.
 */

public class NewsMainPresenter implements IRxBusPresenter{

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

    }

    @Override
    public void getMoreData() {

    }

    @Override
    public <T> void registerRxBus(Class<T> eventType, Action1<T> action) {

    }

    @Override
    public void unRegisterRxBus() {

    }
}
