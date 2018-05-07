package com.it.onex.onex.ui.fragment.gank.day;

import com.it.onex.onex.base.BasePresenter;
import com.it.onex.onex.bean.GankIoDayBean;
import com.it.onex.onex.bean.GankioHistory;
import com.it.onex.onex.bean.TempGankDayBean;
import com.it.onex.onex.net.GankioApi;
import com.it.onex.onex.net.RetrofitManager;
import com.it.onex.onex.utils.RxSchedulers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Linsa on 2018/5/7:11:22.
 * des:
 */

public class GankDayPresenterImp extends BasePresenter<GankDayContract.View> implements GankDayContract.Presenter {


    @Inject
    public GankDayPresenterImp() {
    }

    @Override
    public void loadGankDayData() {
        RetrofitManager.createGankIo(GankioApi.class).getGankIoHistory()
                .compose(mView.<GankioHistory>bindToLife())
                .compose(RxSchedulers.<GankioHistory>applySchedulers())
                .doOnNext(new Consumer<GankioHistory>() {
                    @Override
                    public void accept(GankioHistory gankioHistory) throws Exception {

                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<GankioHistory, Observable<GankIoDayBean>>() {

                    @Override
                    public Observable<GankIoDayBean> apply(GankioHistory gankioHistory) throws Exception {
                        String date = gankioHistory.getResults().get(0);

                        String[] split = date.split("-");
                        return RetrofitManager.createGankIo(GankioApi.class).getGankIoDay(split[0], split[1], split[2]);
                    }
                }).compose(RxSchedulers.applySchedulers())
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {
                        GankIoDayBean bean = (GankIoDayBean) o;

                        List<TempGankDayBean> list=new ArrayList<>();
                        List<GankIoDayBean.ResultsBean.AndroidBean> android = bean.getResults().getAndroid();
                        for (int j = 0; j < android.size(); j++) {
                            TempGankDayBean tempData=new TempGankDayBean();

                            tempData.setTitle("Android");
                            tempData.set_id(android.get(j).get_id());
                            tempData.setCreatedAt(android.get(j).getCreatedAt());
                            tempData.setDesc(android.get(j).getDesc());
                            tempData.setPublishedAt(android.get(j).getPublishedAt());
                            tempData.setImages(android.get(j).getImages());
                            tempData.setSource(android.get(j).getSource());
                            tempData.setUrl(android.get(j).getUrl());
                            tempData.setWho(android.get(j).getWho());
                            list.add(tempData);
                        }

                        List<GankIoDayBean.ResultsBean.AppBean> app = bean.getResults().getApp();
                        for (int j = 0; j < app.size(); j++) {
                            TempGankDayBean tempData=new TempGankDayBean();
                            tempData.setTitle("APP");
                            tempData.set_id(app.get(j).get_id());
                            tempData.setCreatedAt(app.get(j).getCreatedAt());
                            tempData.setDesc(app.get(j).getDesc());
                            tempData.setPublishedAt(app.get(j).getPublishedAt());
                            tempData.setImages(app.get(j).getImages());
                            tempData.setSource(app.get(j).getSource());
                            tempData.setUrl(app.get(j).getUrl());
                            tempData.setWho(app.get(j).getWho());
                            list.add(tempData);
                        }

                        List<GankIoDayBean.ResultsBean.IOSBean> ios = bean.getResults().getIOS();
                        for (int j = 0; j < ios.size(); j++) {
                            TempGankDayBean tempData=new TempGankDayBean();
                            tempData.setTitle("IOS");
                            tempData.set_id(ios.get(j).get_id());
                            tempData.setCreatedAt(ios.get(j).getCreatedAt());
                            tempData.setDesc(ios.get(j).getDesc());
                            tempData.setPublishedAt(ios.get(j).getPublishedAt());
                            tempData.setImages(ios.get(j).getImages());
                            tempData.setSource(ios.get(j).getSource());
                            tempData.setUrl(ios.get(j).getUrl());
                            tempData.setWho(ios.get(j).getWho());
                            list.add(tempData);
                        }


                        List<GankIoDayBean.ResultsBean.拓展资源Bean> tzData = bean.getResults().get拓展资源();
                        for (int j = 0; j < tzData.size(); j++) {
                            TempGankDayBean tempData=new TempGankDayBean();
                            tempData.setTitle("拓展资源");
                            tempData.set_id(tzData.get(j).get_id());
                            tempData.setCreatedAt(tzData.get(j).getCreatedAt());
                            tempData.setDesc(tzData.get(j).getDesc());
                            tempData.setPublishedAt(tzData.get(j).getPublishedAt());
                            ArrayList<String> strings = new ArrayList<>();
                            strings.add("R.mipmap.img_default_meizi");
                            tempData.setImages(strings);
                            tempData.setSource(tzData.get(j).getSource());
                            tempData.setUrl(tzData.get(j).getUrl());
                            tempData.setWho(tzData.get(j).getWho());
                            list.add(tempData);
                        }




                        mView.showDayData(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showFaild(throwable.getMessage().toString());
                    }
                });


    }

    @Override
    public void refresh() {

    }
}
