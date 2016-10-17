package com.example.iancu.asosclothes.models;

import com.google.gson.annotations.Expose;

/**
 * Created by Iancu on 17/10/2016.
 */

public class FacetValue {
    // THIS IS PRACTICALLY USELESS BUT IT IS NECESSARY
    @Expose
    private Integer count;
    @Expose
    private String id;
    @Expose
    private String name;

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The Count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The Name
     */
    public void setName(String name) {
        this.name = name;
    }
}
