package com.example.iancu.asosclothes.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iancu on 17/10/2016.
 */

public class Facet {
    // THIS IS PRACTICALLY USELESS BUT IT IS NECESSARY

    @Expose
    private List<FacetValue> facetValues = new ArrayList<FacetValue>();
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private Integer sequence;

    /**
     *
     * @return
     * The facetValues
     */
    public List<FacetValue> getFacetValues() {
        return facetValues;
    }

    /**
     *
     * @param facetValues
     * The FacetValues
     */
    public void setFacetValues(List<FacetValue> facetValues) {
        this.facetValues = facetValues;
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

    /**
     *
     * @return
     * The sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     *
     * @param sequence
     * The Sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
