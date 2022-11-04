package com.example.votecasting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class aboutusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Toast.makeText(getApplicationContext(),"this is aboutus activity",Toast.LENGTH_LONG).show();

    }
}
