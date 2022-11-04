package com.example.votecasting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class RegisterActivity extends AppCompatActivity {
    EditText clg, id, phone, hdemail, c01, cp01, c02, cp02, d01, dp01, d02, dp02, b01, bp01, g01, gp01, cl01, clp01, cl02, clp02, cl03, clp03, cl04, clp04;
    Button reg;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        clg = (EditText) findViewById(R.id.college);
        id = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        hdemail = (EditText) findViewById(R.id.head);
        c01 = (EditText) findViewById(R.id.c1);
        cp01 = (EditText) findViewById(R.id.cp1);
        c02 = (EditText) findViewById(R.id.c2);
        cp02 = (EditText) findViewById(R.id.cp2);
        d01 = (EditText) findViewById(R.id.d1);
        dp01 = (EditText) findViewById(R.id.dp1);
        d02 = (EditText) findViewById(R.id.d2);
        dp02 = (EditText) findViewById(R.id.dp2);
        b01 = (EditText) findViewById(R.id.b1);
        bp01 = (EditText) findViewById(R.id.bp1);
        g01 = (EditText) findViewById(R.id.g1);
        gp01 = (EditText) findViewById(R.id.gp1);
        cl01 = (EditText) findViewById(R.id.cl1);
        clp01 = (EditText) findViewById(R.id.clp1);
        cl02 = (EditText) findViewById(R.id.cl2);
        clp02 = (EditText) findViewById(R.id.clp2);
        cl03 = (EditText) findViewById(R.id.cl3);
        clp03 = (EditText) findViewById(R.id.clp3);
        cl04 = (EditText) findViewById(R.id.cl4);
        clp04 = (EditText) findViewById(R.id.clp4);
        reg = (Button) findViewById(R.id.bgevent);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Registration");


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDialog();

            }
        });


    }
    public void OpenDialog(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to Register");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                final String a_college = clg.getText().toString();
                String email = id.getText().toString();
                String cphone = phone.getText().toString();
                String hemail = hdemail.getText().toString();
                String code1 = c01.getText().toString();
                String codep1 = cp01.getText().toString();
                String code2 = c02.getText().toString();
                String codep2 = cp02.getText().toString();
                String design1 = d01.getText().toString();
                String designp1 = dp01.getText().toString();
                String design2 = d02.getText().toString();
                String designp2 = dp02.getText().toString();
                String best1 = b01.getText().toString();
                String bestp1 = bp01.getText().toString();
                String gm1 = g01.getText().toString();
                String gmp1 = gp01.getText().toString();
                String cl1 = cl01.getText().toString();
                String clp1 = clp01.getText().toString();
                String cl2 = cl02.getText().toString();
                String clp2 = clp02.getText().toString();
                String cl3 = cl03.getText().toString();
                String clp3 = clp03.getText().toString();
                String cl4 = cl04.getText().toString();
                String clp4 = clp04.getText().toString();





                final gsscolossus gssbca = new gsscolossus(a_college, email, cphone, hemail, code1, codep1, code2, codep2,
                        design1, designp1, design2, designp2, best1, bestp1, gm1, gmp1, cl1, clp1, cl2, clp2, cl3, clp3, cl4, clp4
                );
                String id = databaseReference.push().getKey();
                String a = a_college + id;
                databaseReference.child(a).setValue(gssbca).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(RegisterActivity.this, "REGISTRATION SUCCESSFUL", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), navigation1.class));
                        RegisterActivity.this.finish();

                    }
                });


            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.create().show();

    }


}
