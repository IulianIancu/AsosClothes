package com.example.iancu.asosclothes.services.observable;

import com.example.iancu.asosclothes.models.Categories;
import com.example.iancu.asosclothes.models.ItemCollection;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Iancu on 16/10/2016.
 */

public interface Asos_API {
    @GET("u/1559445/ASOS/SampleApi/cats_men.json")
    Observable<Categories> getCategories();

    @GET("u/1559445/ASOS/SampleApi/anycat_products.json?catid= catalog01_1001_7618")
    Observable<ItemCollection> getColection();
}
