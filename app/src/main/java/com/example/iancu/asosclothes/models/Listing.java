package com.example.iancu.asosclothes.models;

import com.google.gson.annotations.Expose;

/**
 * Created by Iancu on 16/10/2016.
 */

public class Listing {
    @Expose
    private String categoryId;
    @Expose
    private String name;
    @Expose
    private Integer productCount;

    /**
     *
     * @return
     * The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The CategoryId
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

    /**
     *
     * @return
     * The productCount
     */
    public Integer getProductCount() {
        return productCount;
    }

    /**
     *
     * @param productCount
     * The ProductCount
     */
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}
