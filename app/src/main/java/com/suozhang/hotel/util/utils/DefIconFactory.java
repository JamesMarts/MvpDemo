package com.suozhang.hotel.util.utils;

import com.suozhang.hotel.R;

import java.util.Random;

/**
 * Created by long on 2016/9/23.
 * 默认背景工厂类
 */
public final class DefIconFactory {

    private final static int[] DEF_ICON_ID = new int[] {
            R.mipmap.ic_ar_4_3_inside,
            R.mipmap.ic_ar_4_3_inside,
            R.mipmap.ic_ar_4_3_inside,
            R.mipmap.ic_ar_4_3_inside,
            R.mipmap.ic_ar_4_3_inside
    };

    private static Random sRandom = new Random();

    private DefIconFactory() {
        throw new RuntimeException("DefIconFactory cannot be initialized!");
    }


    public static int provideIcon() {
        int index = sRandom.nextInt(DEF_ICON_ID.length);
        return DEF_ICON_ID[index];
    }
}
