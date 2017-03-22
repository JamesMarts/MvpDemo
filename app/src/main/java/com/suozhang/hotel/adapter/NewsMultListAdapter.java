package com.suozhang.hotel.adapter;


import android.content.Context;

import com.dl7.recycler.adapter.BaseMultiItemQuickAdapter;
import com.dl7.recycler.adapter.BaseViewHolder;

import java.util.List;

/**
 * Created by LIJUWEN on 2017/3/22.
 */

public class NewsMultListAdapter extends BaseMultiItemQuickAdapter<NewsMultiItem> {

    public NewsMultListAdapter(Context context, List<NewsMultiItem> data) {
        super(context, data);
    }

    public NewsMultListAdapter(Context context) {
        super(context);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */




    @Override
    protected void attachItemType() {

    }

    @Override
    protected void convert(BaseViewHolder helper, NewsMultiItem item) {

    }
}
