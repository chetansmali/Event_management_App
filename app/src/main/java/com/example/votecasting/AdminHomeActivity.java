package com.example.votecasting;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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


public class AdminHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   public FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"mailto@gmail.com"};
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
            firebaseAuth.getInstance().signOut();
            finish();
            Intent kiai = new Intent(AdminHomeActivity.this, SelectActivity.class);
            startActivity(kiai);
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
                Intent x = new Intent(AdminHomeActivity .this,eventActivity.class);
                startActivity(x);
                return true;

            case R.id.schedule:
                Intent y = new Intent(AdminHomeActivity .this,scheduleActivity.class);
                startActivity(y);
                return true;

            case R.id.preass:
                Intent c = new Intent(AdminHomeActivity  .this,preassigmentActivity.class);
                startActivity(c);
                return true;


            case R.id.score:
                Intent e = new Intent(AdminHomeActivity .this,AddScoreActivity.class);
                startActivity(e);
                return true;

            case R.id.viewres:
                Intent ze = new Intent(AdminHomeActivity .this,RegisterDetails.class);
                startActivity(ze);
                return true;

            case R.id.gallery:
                Intent f = new Intent(AdminHomeActivity  .this,gallaryActivity.class);
                startActivity(f);
                return true;


            case R.id.contact:
                Intent g = new Intent(AdminHomeActivity  .this,HelpDesk.class);
                startActivity(g);
                return true;

            case R.id.about:
                Intent h = new Intent(AdminHomeActivity .this,aboutusActivity.class);
                startActivity(h);
                return true;
            case R.id.map:
                Intent m = new Intent(AdminHomeActivity.this,MapsActivity.class);
                startActivity(m);
                return true;


            case R.id.logout:
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }

    }

//    DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
}

