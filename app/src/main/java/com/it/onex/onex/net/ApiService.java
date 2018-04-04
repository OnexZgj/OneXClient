package com.it.onex.onex.net;

import com.it.onex.onex.bean.Article;
import com.it.onex.onex.bean.BannerData;
import com.it.onex.onex.bean.DataResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by OneXzgj on 2018/4/3:09:56.
 * des:网络请求接口
 */

public interface ApiService {

    /**
     * 获取文章列表的操作
     * http://www.wanandroid.com/article/list/0/json
     * @param page 页码，拼接在连接中，从0开始。
     * @return
     */
    @GET("/article/list/{page}/json")
    Observable<DataResponse<Article>> getHomeArticles(@Path("page") int page);


    /**
     * 获取首页的Banner的操作
     * http://www.wanandroid.com/banner/json
     * @return
     */
    @GET("/banner/json")
    Observable<DataResponse<List<BannerData>>> getHomeBanners();



    /**
     * 收藏站内文章
     *  http://www.wanandroid.com/lg/collect/1165/json
     * @param id 文章的id
     * @return
     */
    @POST("/lg/collect/{id}/json")
    Observable<DataResponse> collectArticle(@Path("id") int id);


    /**
     * 删除收藏文章
     *
     * @param id 文章id
     * @param originId 列表页下发，无则为-1
     * @return Deferred<DataResponse>
     */
    @POST("/lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<DataResponse> removeCollectArticle(@Path("id") int id, @Field("originId") int originId);
}
