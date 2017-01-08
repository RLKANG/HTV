package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Backend.Interpreter;

public class TaskActivity extends AppCompatActivity {
    private Interpreter interpreter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intent = getIntent();
        interpreter = (Interpreter) intent.getSerializableExtra("interpreter");
    }


    public void Add(View view) {
        String name = ((EditText) findViewById(R.id.newTask)).getText().toString();
        int point = Integer.parseInt(((EditText) findViewById(R.id.newPoints)).getText().toString());
        if (point <0) {
            Toast.makeText(this, getString(R.string.negativePoints), Toast.LENGTH_SHORT).show();
        } else {
            interpreter.addTask(name,point);
        }
    }

    public void Go_Home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
