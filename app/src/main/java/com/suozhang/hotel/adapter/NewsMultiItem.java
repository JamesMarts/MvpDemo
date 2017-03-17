package com.suozhang.hotel.adapter;

import android.support.annotation.IntDef;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.suozhang.hotel.api.bean.NewsInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by LIJUWEN on 2017/3/16.
 */

public class NewsMultiItem  implements MultiItemEntity {

    @Override
    public int getItemType() {
        return 0;
    }
    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_PHOTO_SET = 2;

    private NewsInfo mNewsBean;

    public NewsMultiItem(@NewsItemType int itemType, NewsInfo newsBean) {

        mNewsBean = newsBean;
    }

    public NewsInfo getNewsBean() {
        return mNewsBean;
    }

    public void setNewsBean(NewsInfo newsBean) {
        mNewsBean = newsBean;
    }

//    public static void setItemTypeNormal(int itemTypeNormal) {
//        this.setItemType(itemTypeNormal);
//    }


    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ITEM_TYPE_NORMAL, ITEM_TYPE_PHOTO_SET})
    public @interface NewsItemType {}

}
