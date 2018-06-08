package com.example.fryan.practica_login_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

 private  TextView Name;
 //private  String Description ="SoftDeveloper";
 private  TextView T_Description;
  private   Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_profile);
         Name = findViewById(R.id.Name_id);
        bundle=getIntent().getExtras();
        Name.setText(bundle.getString("name"));
    }
}
