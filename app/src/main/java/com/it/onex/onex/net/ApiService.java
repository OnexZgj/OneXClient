package com.it.onex.onex.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by OneXzgj on 2018/4/3:09:56.
 * des:网络请求接口
 */

public interface ApiService {

//    http://www.wanandroid.com/article/list/0/json
//    方法：GET
//    参数：页码，拼接在连接中，从0开始。

    @GET("/article/list/{page}/json")
    Observable<Object> getHomeArticles(@Path("page") int page);


}
