package com.example.iancu.asosclothes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.iancu.asosclothes.connection.ConnectionService;
import com.example.iancu.asosclothes.models.Categories;
import com.example.iancu.asosclothes.models.Listing;
import com.example.iancu.asosclothes.models.ItemCollection;
import com.example.iancu.asosclothes.models.ItemListing;
import com.example.iancu.asosclothes.models.ResultModel;
import com.example.iancu.asosclothes.models.ResultSetModel;
import com.example.iancu.asosclothes.services.observable.Asos_API;
import com.example.iancu.asosclothes.services.observable.Itunes_API;
import com.example.iancu.asosclothes.statics.TempCategories;
import com.example.iancu.asosclothes.utils.RxUtils;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    Menu menu;
    NavigationView navigationView;
    private Asos_API api;
    private Itunes_API testAPI;
    private CompositeSubscription subscription = new CompositeSubscription();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBaseDisplay();

        getCategsFromServer();
//        getItemsFromServer();
//        testItunes();

//        addStatics();
//        ContentFragment fragment = new ContentFragment();
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.frame,fragment);
//        fragmentTransaction.commit();


//        ItemFragment fragment = new ItemFragment();
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.frame,fragment);
//        fragmentTransaction.commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.side, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getBaseContext(), "CLICK",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_banana) {
            Toast.makeText(getBaseContext(), "BANANAAAAaaaAAAaaaAAAaaaAAA",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
//        Changed my mind, whatever button happens, go to the items
        ContentFragment fragment = new ContentFragment();
        Bundle bundle =new Bundle();
        bundle.clear();
        bundle.putString("categoryID",item.getTitle().toString());
        fragment.setArguments(bundle);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();




//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//        if (item.getTitle() =="Nothing")Toast.makeText(getBaseContext(), "@(O_O)@",Toast.LENGTH_SHORT).show();
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//            Toast.makeText(getBaseContext(), "Boop",Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.nav_gallery) {
//            Toast.makeText(getBaseContext(), "Beep",Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.nav_slideshow) {
//            Toast.makeText(getBaseContext(), "Bloop",Toast.LENGTH_SHORT).show();
//
//        } else if (id == R.id.nav_manage) {
//            Toast.makeText(getBaseContext(), "Bleep",Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.nav_share) {
//            Toast.makeText(getBaseContext(), "FWOOOSH",Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.nav_send) {
//            Toast.makeText(getBaseContext(), "EEEEEYYY LMAO",Toast.LENGTH_SHORT).show();
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void initBaseDisplay(){
        setContentView(R.layout.activity_side);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Emails are too expensive", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        menu = navigationView.getMenu();
        menu.clear();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void getCategsFromServer(){
        api = ConnectionService.getConnectionService();
        subscription.add(api.getCategories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Categories>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error: ",e.toString());

                    }

                    @Override
                    public void onNext(Categories categories) {
                        Log.e("HEEE: ",""+categories.getDescription());
                        Log.e("HEEE: ",""+categories.getSortType());
                        List<Categories.Listing> list = categories.getListing();
                        Log.e("HEEE: ",""+list.size());
                        for (Categories.Listing c:list
                             ) {

                            menu.add(c.getName());

                        }


                    }
                }));
    }

    @Override
    protected void onDestroy() {
        subscription.unsubscribe();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        subscription = RxUtils.getNewCompositeSubIfUnsubscribed(subscription);
    }
    public void getItemsFromServer(){
//        api = ConnectionService.getConnectionService();
//        subscription.add(api.getColection()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<ItemCollection>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("Error: ",e.toString());
//
//                    }
//
//                    @Override
//                    public void onNext(ItemCollection colection) {
//                        Log.e("HEEE: ",""+colection.getItemCount());
//                        Log.e("HEEE: ",""+colection.getItemListings().size());
//                        List<ItemListing> list = colection.getItemListings();
//                        Log.e("HEEE: ",""+list.size());
//                        for (ItemListing c:list
//                                ) {
//
//                            menu.add(c.getTitle());
//
//                        }
//
//
//                    }
//                }));

    }
    public void testItunes(){
//        testAPI = ConnectionService.getConnectionService();
        subscription.add(testAPI.getClassic()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultSetModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Error: ",e.toString());

                    }

                    @Override
                    public void onNext(ResultSetModel resultSetModel) {
                        Log.e("HEEE: ",""+resultSetModel.getResultCount());
                        Log.e("HEEE: ",""+resultSetModel.getResults().size());
                        List<ResultModel> list = resultSetModel.getResults();
                        Log.e("HEEE: ",""+list.size());
                        for (ResultModel c:list
                                ) {
                            Log.e("HEEE: ",""+c.getTrackName());
                            menu.add(c.getTrackName());

                        }


                    }
                }));

    }
    public void addStatics(){
        TempCategories temp = new TempCategories();
        for (String s:temp.categories
             ) {
            menu.add(s);
        }

    }


}
