package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }

    public void Set(View view) {
    }

    public void Add(View view) {
    }

    public void Go_Home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
