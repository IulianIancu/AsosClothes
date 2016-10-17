package com.example.iancu.asosclothes.connection;
import com.example.iancu.asosclothes.services.constants.Constants;
import com.example.iancu.asosclothes.services.observable.Asos_API;
import com.example.iancu.asosclothes.services.observable.Itunes_API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Iancu on 13/10/2016.
 */

public class ConnectionService {
    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient;

    public static Asos_API getConnectionService(){
        okHttpClient = buildClient();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit.create(Asos_API.class);
    }

    public static OkHttpClient buildClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
//



    }
}