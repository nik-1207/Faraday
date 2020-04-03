package com.ai.faraday;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {


    ReadAndWriteAppData user;
    Intent login, voice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = new ReadAndWriteAppData();
        login = new Intent(getApplicationContext(), Activity_login.class);
        voice = new Intent(getApplicationContext(), voice_activity.class);



        //checking existing user data
        try {
            user.readFileData(MainActivity.this);
            //if user data exist go to voice Agent

            startActivity(voice);

        }
        //if user data not found go to login page and register for new user
        catch (FileNotFoundException e) {
            startActivity(login);

        }
    }
}
