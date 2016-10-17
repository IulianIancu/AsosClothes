package com.example.iancu.asosclothes.services.observable;

import com.example.iancu.asosclothes.models.ResultSetModel;

import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by Iancu on 13/10/2016.
 */

public interface Itunes_API {
    @GET("search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<ResultSetModel> getClassic();
    @GET("search?term=pop&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<ResultSetModel> getPop();
    @GET("search?term=rock&amp;media=music&amp;entity=song&amp;limit=50")
    Observable<ResultSetModel> getRock();

}
