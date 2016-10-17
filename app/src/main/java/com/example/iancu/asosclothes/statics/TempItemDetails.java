package com.example.iancu.asosclothes.statics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iancu on 17/10/2016.
 */

public class TempItemDetails {
    public  String currentPrice ="£35.00";
    public  boolean inStock =true;
    public  int prodID=1703489;
    public  List<String> images;
    public  String itemTitle;

public TempItemDetails(){
    images =new ArrayList<>();
    images.add("http://images.asos.com/inv/media/9/8/4/3/1703489/red/image1xxl.jpg");
    images.add("http://images.asos.com/inv/media/9/8/4/3/1703489/image2xxl.jpg");
    images.add("http://images.asos.com/inv/media/9/8/4/3/1703489/image3xxl.jpg");
    images.add( "http://images.asos.com/inv/media/9/8/4/3/1703489/image4xxl.jpg");
    currentPrice ="£35.00";
    inStock =true;
    prodID=1703489;
    itemTitle ="ASOS Fringe Sleeve Mesh Crop";


}


}
