package com.example.iancu.asosclothes.statics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iancu on 17/10/2016.
 */

public class TempItems {
    public List<TempItem> items;
    public TempItems(){
        items =new ArrayList<>();
        items.add(new TempItem("£30.00","ASOS Blouse With Tipped Drop Collar",
                "http://images.asos.com/inv/media/8/3/8/3/1743838/creamblack/image1xl.jpg",
                1743838));
        items.add(new TempItem("£30.00","ASOS Mini Skirt With Pocket Front Panel",
                "http://images.asos.com/inv/media/6/1/6/5/1755616/spectrumblue/image1xl.jpg",
                1755616));
        items.add(new TempItem("£30.00","ASOS Midi Skirt in Quilted Jersey",
                "http://images.asos.com/inv/media/9/6/1/0/1760169/black/image1xl.jpg",
                1760169));
    }
}
