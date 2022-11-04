package com.example.votecasting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.votecasting.ui.User;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class RegisterDetails extends AppCompatActivity {
    ListView mylistview;
    ArrayList<String> myarrayList = new ArrayList<>();
    DatabaseReference mRef;
    FirebaseDatabase database;
    User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_details);
        user = new User();
        mylistview = (ListView)findViewById(R.id.listview1);
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("Registration");
        final ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<>(RegisterDetails.this,android.R.layout.simple_list_item_multiple_choice,myarrayList);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    user = ds.getValue(User.class);
                    myarrayList.add(user.getA_college_name());
                }
                mylistview.setAdapter(myarrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }
}
