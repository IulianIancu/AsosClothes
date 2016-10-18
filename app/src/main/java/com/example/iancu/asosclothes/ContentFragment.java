package com.example.iancu.asosclothes;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iancu.asosclothes.connection.ConnectionService;
import com.example.iancu.asosclothes.models.ItemCollection;
import com.example.iancu.asosclothes.models.ItemListing;
import com.example.iancu.asosclothes.services.observable.Asos_API;
import com.example.iancu.asosclothes.statics.TempItems;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Iancu on 16/10/2016.
 */

public class ContentFragment extends Fragment{
    private FragmentActivity myContext;
    private FragmentManager fragManager;
    private Asos_API api;
    private CompositeSubscription subscription = new CompositeSubscription();
    static List<ItemListing> returnList;
    private String catID;

    RecyclerView recyclerView;
//    SwipeRefreshLayout refreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_frag,container,false);
        recyclerView =(RecyclerView)  v.findViewById(R.id.list);
//        refreshLayout =(SwipeRefreshLayout) v.findViewById(R.id.refresh);
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),2));
        catID = getArguments().getString("categoryID");

//        TempItems items= new TempItems();
        fragManager = myContext.getSupportFragmentManager();
        getItems();

//        ContentAdapter adapter =new ContentAdapter(returnList,R.layout.grid_element,v.getContext(),fragManager);
//        recyclerView.setAdapter(adapter);


//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshLayout.setRefreshing(false);
//            }
//
//        });

        return v;
    }
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    private void getItems(){

        api = ConnectionService.getConnectionService();
        subscription.add(api.getColection(catID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemCollection>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error: ",e.toString());

                    }

                    @Override
                    public void onNext(ItemCollection colection) {
                        Log.e("HEEE: ",""+colection.getItemCount());
                        Log.e("HEEE: ",""+colection.getItemListings().size());
                        List<ItemListing> list = colection.getItemListings();
                        Log.e("HEEE: ",""+list.size());

                        ContentAdapter adapter =new ContentAdapter(list,R.layout.grid_element,ContentFragment.this.getContext(),fragManager);
                        recyclerView.setAdapter(adapter);
                        Log.e("HEEE: ",""+returnList.size());


                    }
                }));
    }
    

}
