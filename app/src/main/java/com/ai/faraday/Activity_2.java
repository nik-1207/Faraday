package com.ai.faraday;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Activity_2 extends AppCompatActivity
{
    Button voiceButton;
    Permissions permission;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        voiceButton = findViewById(R.id.buttonVoice);
        permission=new Permissions();

        voiceButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!permission.hasPermissions(Activity_2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    permission.grantPermission(Activity_2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE);
                }
               
            }
        });
    }


}

