package com.suozhang.hotel.moudle.base;

import rx.functions.Action1;

/**
 * Created by LIJUWEN on 2017/3/20.
 */

public interface IRxBusPresenter extends  IBasePresenter{

    /**
     * 注册RxBus event
     * */

    <T> void registerRxBus(Class<T> eventType, Action1<T> action);

    /**
     *
     * 注销
     * */

    void unRegisterRxBus();

}
