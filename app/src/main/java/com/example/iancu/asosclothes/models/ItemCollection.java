package com.example.iancu.asosclothes.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iancu on 17/10/2016.
 */

public class ItemCollection {
    @Expose
    private List<Object> alsoSearched = new ArrayList<Object>();
    @Expose
    private String description;
    @Expose
    private List<Facet> facets = new ArrayList<Facet>();
    @Expose
    private Integer itemCount;
    @Expose
    private List<ItemListing> itemListings = new ArrayList<ItemListing>();
    @Expose
    private String redirectUrl;
    @Expose
    private String sortType;

    /**
     *
     * @return
     * The alsoSearched
     */
    public List<Object> getAlsoSearched() {
        return alsoSearched;
    }

    /**
     *
     * @param alsoSearched
     * The AlsoSearched
     */
    public void setAlsoSearched(List<Object> alsoSearched) {
        this.alsoSearched = alsoSearched;
    }

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
     * The facets
     */
    public List<Facet> getFacets() {
        return facets;
    }

    /**
     *
     * @param facets
     * The Facets
     */
    public void setFacets(List<Facet> facets) {
        this.facets = facets;
    }

    /**
     *
     * @return
     * The itemCount
     */
    public Integer getItemCount() {
        return itemCount;
    }

    /**
     *
     * @param itemCount
     * The ItemCount
     */
    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    /**
     *
     * @return
     * The itemListings
     */
    public List<ItemListing> getItemListings() {
        return itemListings;
    }

    /**
     *
     * @param itemListings
     * The Listings
     */
    public void setItemListings(List<ItemListing> itemListings) {
        this.itemListings = itemListings;
    }

    /**
     *
     * @return
     * The redirectUrl
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     *
     * @param redirectUrl
     * The RedirectUrl
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
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
