package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import Backend.Interpreter;

public class EditTask extends AppCompatActivity {
    private Interpreter interpreter;
    private int index;
    EditText name = (EditText) findViewById(R.id.editTaskName);
    EditText point = (EditText) findViewById(R.id.editTaskPoint);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        Intent intent = getIntent();
        interpreter = (Interpreter) intent.getSerializableExtra("interpreter");
        index = (int) intent.getSerializableExtra("index");

    }
}
