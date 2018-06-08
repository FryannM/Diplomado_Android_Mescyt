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




public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button ButtonLogin;
    private EditText Edit_User, Edit_Psw;
    private TextView Tv_mensaje;
    private  TextView Tv_Descripcion;
    private  String Description = "SoftDeveloper";
    private int counter = 3;
    private  TextView Tv_Forget;
    private Button ButtonShare;
    private  String Url ="https://github.com/FryannM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButtonLogin = findViewById(R.id.LoginButon);
        Edit_User = findViewById((R.id.Email_id));
        Edit_Psw = findViewById(R.id.password_id);
        Tv_mensaje = findViewById(R.id.mensaje_id);
        ButtonShare = findViewById(R.id.shareProfile_id);
        Tv_Forget = findViewById(R.id.forgotshare_id);



        findViewById(R.id.LoginButon).setOnClickListener(this);
        findViewById(R.id.Button_shareProfile).setOnClickListener(this);
        findViewById(R.id.forgotshare_id).setOnClickListener(this);



    }
        @Override
        public void onClick (View v){

            switch (v.getId()) {
                case R.id.LoginButon: {

                    if (Edit_User.getText().toString().equals("fryannm@gmail.com") && Edit_Psw.getText().toString().equals("*"))

                    {
                        Toast.makeText(getApplicationContext(),
                                "Redirecting...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.putExtra("name", Edit_User.getText().toString());
//                        intent.putExtra("Description",Tv_Descripcion.setText(Description).toString());


                        startActivity(intent);

                    } else {


                        Toast.makeText(getApplicationContext(), "Wrong Password or email address", Toast.LENGTH_SHORT).show();

                        Edit_User.setVisibility(View.VISIBLE);

                        counter--;
                        Tv_mensaje.setText(counter + " Attempts");


                        if (counter == 0) {
                            Toast.makeText(getApplicationContext(), "Try again Later ", Toast.LENGTH_SHORT).show();
                            ButtonLogin.setEnabled(false);
                            finish();
                        }
                    }

                }
                break;

                case R.id.Button_shareProfile: {


                        Intent intent  = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT,Url);
                        intent.putExtra(Intent.EXTRA_TEXT,Url);
                        startActivity(Intent.createChooser(intent,"Sharing Fryann Files "));

                }
                case R.id.forgotshare_id:
                {
                    Toast.makeText(this, "We Working On it ", Toast.LENGTH_SHORT).show();

                }
                break;
            }
        }
    }




