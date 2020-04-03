package com.ai.faraday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_login extends AppCompatActivity {
    ReadAndWriteAppData user;
    Button register;
    EditText username;
    Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = new ReadAndWriteAppData();
        register = findViewById(R.id.button);
        username = findViewById(R.id.editText);
        main = new Intent(getApplicationContext(), MainActivity.class);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if user entered their name or edit block is empty
                if (!username.getText().toString().equals("")) {
                    //if block is not empty then save the data for new user i.e name and go to main activity
                    user.writeFileData(Activity_login.this, username.getText().toString());
                    startActivity(main);
                    finish();

                }

            }
        });

    }
}
