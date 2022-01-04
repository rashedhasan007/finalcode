package rashed.hasan.hone;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements addproduct.OnFragmentInteractionListener,customwebview.OnFragmentInteractionListener,createshop.OnFragmentInteractionListener,customwebviewshare.OnFragmentInteractionListener,editprofile.OnFragmentInteractionListener{

    SNavigationDrawer sNavigationDrawer;
    int color1=0;
    Class fragmentClass;
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    public static Fragment fragment;
    //webview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }

        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Home",R.drawable.news_bg));
        menuItems.add(new MenuItem("Order",R.drawable.feed_bg));
        menuItems.add(new MenuItem("Product",R.drawable.message_bg));
        menuItems.add(new MenuItem("Profile",R.drawable.music_bg));
        menuItems.add(new MenuItem("Theme",R.drawable.photo));
        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  first.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();
        }


        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position){
                    case 0:{
                        color1 = R.color.colorAccent;
                        fragmentClass = first.class;
                        break;
                    }
                    case 1:{
                        color1 = R.color.colorAccent;
                        fragmentClass = order.class;
                        break;
                    }
                    case 2:{
                        color1 = R.color.colorAccent;
                        fragmentClass = product.class;
                        break;
                    }
                    case 3:{
                        color1 = R.color.colorPrimary;
                        Intent i = new Intent(getApplicationContext(),reselleractivity.class);
                        startActivity(i);
                    }
                    case 4:{
                        color1 = R.color.colorPrimary;
                        fragmentClass = theme.class;
                        break;
                    }

                }
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State "+newState);
                    }
                });
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}