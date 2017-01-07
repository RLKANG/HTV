package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Backend.Interpreter;
import Backend.Task;

public class EditTask extends AppCompatActivity {
    private Interpreter interpreter;
    private int index;
    EditText name = (EditText) findViewById(R.id.editTaskName);
    EditText point = (EditText) findViewById(R.id.editTaskPoint);
    EditText note = (EditText) findViewById(R.id.editTaskNote);
    private Task task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        Intent intent = getIntent();
        interpreter = (Interpreter) intent.getSerializableExtra("interpreter");
        index = (int) intent.getSerializableExtra("index");
        task=interpreter.getTask(index);
        name.setText(task.getName());
        point.setText(task.getPoint());
        note.setText(task.getNote());
    }

    public void submitEditTask(View view){
        String name = ((EditText) findViewById(R.id.editTaskName)).getText().toString();
        int point = Integer.parseInt(((EditText) findViewById(R.id.editTaskPoint)).getText().toString());
        String note=((EditText) findViewById(R.id.editTaskNote)).getText().toString();
        if (point < 0) {
            Toast.makeText(this, getString(R.string.negativePoints), Toast.LENGTH_SHORT).show();
        } else {
            interpreter.getTask(index).setName(name);
            interpreter.getTask(index).setPoint(point);
            interpreter.getTask(index).setNote(note);
            Toast.makeText(this, getString(R.string.taskModified), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, TaskActivity.class);
            intent.putExtra("interpreter",interpreter);
            startActivity(intent);
        }
    }
}
