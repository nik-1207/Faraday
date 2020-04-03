package com.ai.faraday;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class voice_activity extends AppCompatActivity {
    Button speak;
    Permissions permission;
    TextView text;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        speak = findViewById(R.id.button2);
        permission = new Permissions();
        text = findViewById(R.id.textView);
        builder = new AlertDialog.Builder(voice_activity.this);


//setting up listner button
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking for permissions
                if (!permission.hasPermissions(voice_activity.this, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO)) {
                    permission.grantPermission(voice_activity.this, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO);

                }

                if (permission.hasPermissions(voice_activity.this, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO)) {
                    text.setText("listening...");
                }
            }

        });

    }

    // setting up back button
    @Override
    public void onBackPressed() {
        builder.setTitle("Confirm");
        builder.setMessage("Are you Sure to exit the app?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog = builder.create();
        dialog.show();
    }
}
