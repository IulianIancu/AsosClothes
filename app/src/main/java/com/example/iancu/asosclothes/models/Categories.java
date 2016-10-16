package com.example.iancu.asosclothes.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iancu on 16/10/2016.
 */

public class Categories {


    @Expose
    private String description;

    @Expose
    private List<CategoryListing> listing = new ArrayList<CategoryListing>();
    @Expose
    private String sortType;

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The Description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The listing
     */
    public List<CategoryListing> getListing() {
        return listing;
    }

    /**
     *
     * @param listing
     * The Listing
     */
    public void setListing(List<CategoryListing> listing) {
        this.listing = listing;
    }

    /**
     *
     * @return
     * The sortType
     */
    public String getSortType() {
        return sortType;
    }

    /**
     *
     * @param sortType
     * The SortType
     */
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
