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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iancu.asosclothes.statics.TempItems;

/**
 * Created by Iancu on 16/10/2016.
 */

public class ContentFragment extends Fragment{
    private FragmentActivity myContext;
    FragmentManager fragManager;

    RecyclerView recyclerView;
//    SwipeRefreshLayout refreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_frag,container,false);
        recyclerView =(RecyclerView)  v.findViewById(R.id.list);
//        refreshLayout =(SwipeRefreshLayout) v.findViewById(R.id.refresh);
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(),2));
        TempItems items= new TempItems();
        fragManager = myContext.getSupportFragmentManager();
        ContentAdapter adapter =new ContentAdapter(items.items,R.layout.grid_element,v.getContext(),fragManager);
        recyclerView.setAdapter(adapter);


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
    

}
