package com.example.votecasting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectActivity extends AppCompatActivity {
    Button ad,fa,par;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ad = (Button)findViewById(R.id.btnadmin);
        fa = (Button)findViewById(R.id.btnfact);
        par = (Button)findViewById(R.id.btnpart);

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectActivity.this, MainActivity.class));
            }
        });
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectActivity.this,FacultyloginActivity.class));
            }
        });
        par.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectActivity.this, navigation1.class));
            }
        });



    }
}
