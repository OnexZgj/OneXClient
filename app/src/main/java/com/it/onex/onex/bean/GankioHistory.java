package com.it.onex.onex.bean;

import java.util.List;

/**
 * Created by Linsa on 2018/5/7:11:02.
 * des:干货发布的历史日期
 */

public class GankioHistory {


    /**
     * error : false
     * results : ["2018-03-12","2018-02-22","2018-02-08","2018-01-29"]
     */

    private boolean error;
    private List<String> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
