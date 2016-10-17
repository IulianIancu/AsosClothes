package com.example.iancu.asosclothes;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iancu.asosclothes.statics.TempItemDetails;

import com.example.iancu.asosclothes.utils.ItemAdapter;

/**
 * Created by Iancu on 17/10/2016.
 */

public class ItemFragment  extends Fragment {
    RecyclerView imageViewer;
    TextView itemTitle;
    TextView itemPrice;
    TextView itemID;
    TextView itemStock;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_fragment,container,false);
        imageViewer =(RecyclerView) v.findViewById(R.id.itemimageColection);
        imageViewer.setLayoutManager(new LinearLayoutManager(v.getContext(),LinearLayoutManager.HORIZONTAL,false));
        TempItemDetails item =new TempItemDetails();
        ItemAdapter adapter = new ItemAdapter(item.images,R.layout.fragment_tabbed,v.getContext());
        imageViewer.setAdapter(adapter);
        itemTitle =(TextView) v.findViewById(R.id.item_title);
        itemPrice =(TextView) v.findViewById(R.id.current_price);
        itemID =(TextView) v.findViewById(R.id.item_id);
        itemStock =(TextView) v.findViewById(R.id.item_in_stock);
        itemTitle.setText(item.itemTitle);
        itemPrice.setText(item.currentPrice);
        itemID.setText("Product id: "+item.prodID);
        itemStock.setText("It is in stock: "+item.inStock);




        return v;

    }

}
