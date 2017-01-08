package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import Backend.Interpreter;

public class MainActivity extends AppCompatActivity {
    private Interpreter interpreter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if(intent.getExtras().containsKey("interpreter")) {
            interpreter = (Interpreter) intent.getSerializableExtra("interpreter");
        }else {
            interpreter = new Interpreter();
        }
    }

    public void viewTasks(View view){
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("interpreter", interpreter);
        startActivity(intent);
    }
    public void viewDesires(View view){
        Intent intent=new Intent(this, DesireActivity.class);
        intent.putExtra("interpreter",interpreter);
        startActivity(intent);
    }

}
