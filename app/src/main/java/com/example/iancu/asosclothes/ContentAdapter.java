package com.example.iancu.asosclothes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iancu.asosclothes.statics.TempItem;
import com.example.iancu.asosclothes.utils.ClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Iancu on 17/10/2016.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

    private List<TempItem> itemList;
    private int rowLayout;
    private Context context;

    public ContentAdapter(List<TempItem> itemList, int rowLayout, Context contxt){
        this.itemList = itemList;
        this.rowLayout=rowLayout;
        this.context=contxt;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TempItem item = itemList.get(position);
        holder.itemName.setText(item.title);
        holder.itemPrice.setText(item.price);
        Picasso.with(context).load(item.img)
                .into(holder.img);
        holder.setClickListener(new ClickListener() {
            @Override
            public void OnClick(View view, int position, boolean isLongClick) {
                Toast.makeText(context, "#" + position + " - " + item.title, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        public TextView itemName;
        public TextView itemPrice;
        public ImageView img;
        private ClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName=(TextView) itemView.findViewById(R.id.itemTitle);
            itemPrice=(TextView) itemView.findViewById(R.id.itemPrice);
            img=(ImageView) itemView.findViewById(R.id.itemImage);

            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.OnClick(v,getPosition(),false);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.OnClick(v,getPosition(),true);
            return false;
        }
        public void setClickListener(ClickListener clickListener){
            this.clickListener =clickListener;
        }
    }
}
