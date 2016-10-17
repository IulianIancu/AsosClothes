package com.example.iancu.asosclothes.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Iancu on 13/10/2016.
 */

public class ResultSetModel {
    @Expose
    private Integer resultCount;
    @Expose
    private List<ResultModel> results = new ArrayList<ResultModel>();
    /**
     *
     * @return
     * The resultCount
     */
    public Integer getResultCount() {
        return resultCount;
    }

    /**
     *
     * @param resultCount
     * The resultCount
     */
    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    /**
     *
     * @return
     * The results
     */
    public List<ResultModel> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<ResultModel> results) {
        this.results = results;
    }

}

