package com.it.onex.onex.net;

import com.it.onex.onex.bean.Article;
import com.it.onex.onex.bean.DataResponse;

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
    Observable<DataResponse<Article>> getHomeArticles(@Path("page") int page);


}
