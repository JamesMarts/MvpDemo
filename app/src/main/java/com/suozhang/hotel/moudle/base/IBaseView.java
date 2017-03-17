package com.suozhang.hotel.moudle.base;

import com.suozhang.hotel.widget.EmptyLayout;
import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by LIJUWEN on 2017/3/16.
 */

public interface IBaseView {

    /**
     * 显示加载动画
     */

    void showLoading();

    /**
     * 隐藏加载动画
     */
    void hideLoading();

    /**
     * 显示网络错误
     * */
    void showNetError(EmptyLayout.OnRetryListener onRetryListener);


    /**
     * 绑定生命周期
     * */

    <T> LifecycleTransformer<T> bindToLife();



}
