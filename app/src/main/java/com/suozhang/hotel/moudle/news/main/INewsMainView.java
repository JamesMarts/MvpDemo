package com.suozhang.hotel.moudle.news.main;

import com.suozhang.hotel.local.table.NewsTypeInfo;

import java.util.List;

/**
 * Created by LIJUWEN on 2017/3/20.
 */

public interface INewsMainView {

    /**
     * 显示选中的栏目
     * */

    void loadData(List<NewsTypeInfo> checkList);
}
