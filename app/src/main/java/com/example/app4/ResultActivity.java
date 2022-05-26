package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void onClickResult(View view){
        MenuActivity.level = 0;
        Intent intent = new Intent(ResultActivity.this, GameActivity.class);
        startActivity(intent);
    }
}