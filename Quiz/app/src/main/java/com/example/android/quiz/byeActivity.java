package com.example.android.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class byeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);

        MyApplication myApp = (MyApplication) getApplication();


        TextView result = findViewById(R.id.result);

        result.setText("Your total score is: " + myApp.getScore());
    }
}
