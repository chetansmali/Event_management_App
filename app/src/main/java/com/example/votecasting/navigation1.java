package com.example.votecasting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class navigation1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private SliderLayout sliderLayout;
private HashMap<String, Integer> sliderImages;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_navigation1);
        Toolbar toolbar = findViewById(R.id.toolbar);


        ///slider
        sliderLayout = findViewById(R.id.sliderLayout);
        sliderImages = new HashMap<>();
        setupSlider();

        ///slider2
        sliderLayout = findViewById(R.id.sliderLayout2);
        sliderImages = new HashMap<>();
        setupSlider2();






        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"gssbca1@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
                intent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
                intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation1, menu);
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
            Intent kia = new Intent( navigation1 .this,SelectActivity.class);
            startActivity(kia);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (item.getItemId())
        {
            case R.id.event:
                Intent x = new Intent(navigation1.this,peventActivity.class);
                startActivity(x);
                return true;

            case R.id.schedule:
                Intent y = new Intent(navigation1.this,scheduleActivity.class);
                startActivity(y);
                return true;

            case R.id.preass:
                Intent c = new Intent(navigation1.this,preassigmentActivity.class);
                startActivity(c);
                return true;


            case R.id.score:
                Intent e = new Intent(navigation1.this,scoreActivity.class);
                startActivity(e);
                return true;

            case R.id.gallery:
                Intent f = new Intent(navigation1.this,pgallaryActivity.class);
                startActivity(f);
                return true;


            case R.id.contact:
                Intent g = new Intent(navigation1.this,HelpDesk.class);
                startActivity(g);
                return true;

            case R.id.about:
                Intent h = new Intent(navigation1.this,aboutusActivity.class);
                startActivity(h);
                return true;


            case R.id.logout:
                return true;

            case R.id.Register:
                Intent k = new Intent(navigation1.this,ProtocolActivity.class);
                startActivity(k);
                return true;

            case R.id.Feedback:
                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSdMJ3VTLEm6QdAllVfnpS0-_Gj4yKMsHLxXUX7J8y2cEFzmLA/viewform?usp=sf_link"));
                startActivity(Getintent);
                return true;


            case R.id.map:
                Intent m = new Intent(navigation1.this,mapActitvity2.class);
                startActivity(m);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupSlider() {
        sliderLayout = (SliderLayout) findViewById(R.id.sliderLayout);
        sliderImages = new HashMap<>();
        sliderImages.put("GSS Campus", R.drawable.ske);
        sliderImages.put("Open Air theater",R.drawable.auto);
        sliderImages.put("Place",R.drawable.statue);



        for (String name : sliderImages.keySet()) {

            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(sliderImages.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);

//        recyclerviewAdapter = new RecyclerviewAdapter(this,products);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(recyclerviewAdapter);
//        loadProducts();
    }
    private void setupSlider2() {
        sliderLayout = (SliderLayout) findViewById(R.id.sliderLayout2);
        sliderImages = new HashMap<>();
        sliderImages.put("GSS BCA Building", R.drawable.gss);
        sliderImages.put("Open Air theater",R.drawable.auto);
        sliderImages.put("Place",R.drawable.statue);



        for (String name : sliderImages.keySet()) {

            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(sliderImages.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(this);

//        recyclerviewAdapter = new RecyclerviewAdapter(this,products);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(recyclerviewAdapter);
//        loadProducts();
    }
    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }





}

