package com.suozhang.hotel.moudle.base;

/**
 * Created by LIJUWEN on 2017/3/16.
 */

public interface ILoadDataView<T> extends IBaseView {
    /**
     * 加载数据
     *
     * @param data
     */
    void loadData(T data);

    /**
     * 加载更多数据
     *
     * @param data
     */

    void loadMoreData(T data);

    /*
    * 没有数据
    * */
    void loadNoData();


}
