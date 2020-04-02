package com.ai.faraday;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;


public class Activity_2 extends AppCompatActivity {
    private static final int REQ_CODE_SPEECH_INPUT = 5;
    Button voiceButton;
    Permissions permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        voiceButton = findViewById(R.id.buttonVoice);
        permission = new Permissions();

        voiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!permission.hasPermissions(Activity_2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO)) {
                    permission.grantPermission(Activity_2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO);
                }
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                /*
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,getString(R.string.speech_prompt));
                */

                try {
                    startActivityForResult(intent,permission.getGRANT_CODE());
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.speech_not_supported),Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

