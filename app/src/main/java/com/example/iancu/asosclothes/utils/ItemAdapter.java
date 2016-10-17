package com.example.iancu.asosclothes.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.iancu.asosclothes.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Iancu on 17/10/2016.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<String>images;
    private int rowLayout;
    private Context context;
    public ItemAdapter(List<String> imges, int rowLayout, Context context){
        this.images =imges;
        this.rowLayout =rowLayout;
        this.context =context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(images.get(position)).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img =(ImageView) itemView.findViewById(R.id.individual_image);
            itemView.setTag(itemView);

        }
    }
}
