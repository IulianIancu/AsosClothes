package com.example.iancu.asosclothes;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_frag,container,false);
        recyclerView =(RecyclerView)  v.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        TempItems items= new TempItems();
        ContentAdapter adapter =new ContentAdapter(items.items,R.layout.grid_element,v.getContext());
        recyclerView.setAdapter(adapter);

        return v;
    }

}
