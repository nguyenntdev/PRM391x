package com.nguyennt.animal;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.nguyennt.animal.ui.gallery.GalleryFragment;
import com.nguyennt.animal.ui.home.HomeFragment;
import com.nguyennt.animal.ui.slideshow.SlideshowFragment;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();

        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_white_menu_24);
        }
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        toggle.syncState();

        drawerLayout.closeDrawers();

        LinearLayout mammalmenu = findViewById(R.id.mammalmenu);
        LinearLayout birdsmenu = findViewById(R.id.birdsmenu);
        LinearLayout seamenu = findViewById(R.id.seamenu);
        ImageView imageViewTitle = findViewById(R.id.titleImageView);

        mammalmenu.setOnClickListener(new View.OnClickListener() {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.content_frame, new HomeFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                imageViewTitle.setVisibility(View.GONE);
            }
        });
        seamenu.setOnClickListener(new View.OnClickListener() {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.content_frame, new GalleryFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                imageViewTitle.setVisibility(View.GONE);

            }
        });
        birdsmenu.setOnClickListener(new View.OnClickListener() {
            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            @Override
            public void onClick(View v) {
                fragmentTransaction.replace(R.id.content_frame, new SlideshowFragment());
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                imageViewTitle.setVisibility(View.GONE);

            }
        });


    }


}