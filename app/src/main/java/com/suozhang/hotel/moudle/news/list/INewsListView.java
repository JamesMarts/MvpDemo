package com.suozhang.hotel.moudle.news.list;

import com.suozhang.hotel.adapter.NewsMultiItem;
import com.suozhang.hotel.api.bean.NewsInfo;
import com.suozhang.hotel.moudle.base.ILoadDataView;

import java.util.List;

/**
 * Created by LIJUWEN on 2017/3/16.
 */

public interface INewsListView extends ILoadDataView<List<NewsMultiItem>> {

    /**
     * 加载新闻数据
     */

    void loadNewsData(NewsInfo newsInfo);


}
