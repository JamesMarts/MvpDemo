package com.suozhang.hotel.api;


import com.suozhang.hotel.api.bean.NewsInfo;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Part;
import retrofit2.http.Path;

import static com.suozhang.hotel.api.RetrofitService.CACHE_CONTROL_NETWORK;

/**
 * Created by long on 2016/8/22.
 * API 接口
 */
public interface INewsApi {

    /**
     * 获取新闻列表
     * eg: http://c.m.163.com/nc/article/headline/T1348647909107/60-20.html
     *      http://c.m.163.com/nc/article/list/T1348647909107/60-20.html
     *
     * @param type 新闻类型
     * @param newsId 新闻ID
     * @param startPage 起始页码
     * @return
     */
    @Headers(CACHE_CONTROL_NETWORK)
    @GET("nc/article/{type}/{newsId}/{startPage}-20.html")
    Observable<Map<String,List<NewsInfo>>> getNewsList(@Path("type") String type,
                                                         @Path("newsId") String newsId, @Part("startPage")int startPage);


}
