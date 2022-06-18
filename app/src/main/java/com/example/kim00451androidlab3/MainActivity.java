package com.example.kim00451androidlab3;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private EditText email, pwd;

    ImageView imgView = new ImageView(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailEnter);
        pwd = findViewById(R.id.pwdEnter);

        ImageButton imageButton = findViewById(R.id.imageButton2);
        Button button = findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("Email", email.getText().toString());
                    startActivity(intent);

                };
            });


    }
                protected void onPause() {
                    super.onPause();
                    SharedPreferences sh = getSharedPreferences("emailEnter", MODE_PRIVATE);
                    SharedPreferences.Editor ed = sh.edit();

                    if (ed != null) {
                        ed.putString("emailEnter", email.getText().toString());
                        ed.putString("pwdEnter", pwd.getText().toString());
                    }

                    ed.commit();
                }




}





