package com.example.iancu.asosclothes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iancu on 16/10/2016.
 */

public class Categories {
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Listing")
    @Expose
    private List<Listing> listing = new ArrayList<Listing>();
    @SerializedName("SortType")
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
    public List<Listing> getListing() {
        return listing;
    }

    /**
     *
     * @param listing
     * The ItemListing
     */
    public void setListing(List<Listing> listing) {
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
    public class Listing {

        @SerializedName("CategoryId")
        @Expose
        private String categoryId;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("ProductCount")
        @Expose
        private Integer productCount;

        /**
         * @return The categoryId
         */
        public String getCategoryId() {
            return categoryId;
        }

        /**
         * @param categoryId The CategoryId
         */
        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The Name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The productCount
         */
        public Integer getProductCount() {
            return productCount;
        }

        /**
         * @param productCount The ProductCount
         */
        public void setProductCount(Integer productCount) {
            this.productCount = productCount;
        }

    }

}


