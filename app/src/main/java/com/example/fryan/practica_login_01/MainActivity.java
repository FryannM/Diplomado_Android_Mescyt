package com.example.fryan.practica_login_01;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


     private Button ButtonLogin;
     private EditText Edit_User, Edit_Psw;
     int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ButtonLogin =  findViewById(R.id.LoginButon);
         Edit_User = findViewById((R.id.Email_id));
         Edit_Psw = findViewById(R.id.password_id);


         ButtonLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {



                  if (Edit_User.getText().toString().equals("fryannm@gmail.com") && Edit_Psw.getText().toString().equals("*"))

                  {
                      Toast.makeText(getApplicationContext(),
                              "Redirecting...",Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                      startActivity(intent);
                  }
                  else {


                     Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                     Edit_User.setVisibility(View.VISIBLE);
                     Edit_User.setBackgroundColor(Color.GREEN);
                     counter --;
                     Edit_User.setText(Integer.toString(counter));


                      if (counter == 0)
                      {
                          ButtonLogin.setEnabled(false);
                      }
                 }




             }
         });


       // Intent intent = new
    }
}
