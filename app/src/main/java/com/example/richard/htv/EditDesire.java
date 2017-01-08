package com.example.richard.htv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import Backend.Interpreter;
import Backend.Task;

public class EditDesire extends AppCompatActivity {
    private Interpreter interpreter;
    private int index;
    EditText name = (EditText) findViewById(R.id.editDesireName);
    EditText point = (EditText) findViewById(R.id.editDesirePoint);
    private Desire desire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_desire);
    }
}
