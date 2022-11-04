package com.example.votecasting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FacultyloginActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView forgotPassword;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText)findViewById(R.id.Email);
        Password = (EditText)findViewById(R.id.password);
        Login = (Button)findViewById(R.id.loginBtn);
        forgotPassword = (TextView)findViewById(R.id.tvForgotPassword);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(FacultyloginActivity.this, FacultyHomeActivity.class));
        }



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = Name.getText().toString();
                String p = Password.getText().toString();
                if (TextUtils.isEmpty(e) || !e.matches("[a-zA-Z0-9._]+@[a-z]+\\.+[a-zA-Z]*")) {

                    Name.setError("EmailID in bad format");
                    Toast.makeText(FacultyloginActivity.this, "Email is to be in correct order", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (TextUtils.isEmpty(p))  {
                    Password.setError("Password is required");
                    return;
                }
                else {
                    validate(Name.getText().toString(), Password.getText().toString());
                }
            }
        });


        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FacultyloginActivity.this, PasswordActivity.class));
            }
        });
    }

    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    //Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    checkEmailVerification();
                }else{
                    Toast.makeText(FacultyloginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }
        });


    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();

        startActivity(new Intent(FacultyloginActivity.this, FacultyHomeActivity.class));

//        if(emailflag){
//            finish();
//            startActivity(new Intent(MainActivity.this, SecondActivity.class));
//        }else{
//            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
//            firebaseAuth.signOut();
//        }
    }

}
