package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.TextView;

import Backend.Interpreter;

public class TaskActivity extends AppCompatActivity {
    private Interpreter interpreter;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Intent intent = getIntent();
        interpreter = (Interpreter) intent.getSerializableExtra("interpreter");
    }

    public void Set(View view) {
    }

    public void Add(View view) {
        //Point in task and desire class are the same???
        if (count < 5) {
            String name = "";
            try {
                name = ((EditText) findViewById(R.id.newTask)).getText().toString();
            } catch (Exception e) {
                name = "";
            }
            int point = -1;
            try {
                point = Integer.parseInt(((EditText) findViewById(R.id.newPoints)).getText().toString());
            } catch (Exception e) {
                point = -1;
            }
            if (name.equals("") || point == -1) {
                Toast.makeText(this, getString(R.string.invalidInput), Toast.LENGTH_SHORT).show();
            } else {
                interpreter.addTask(name, point);
                if (count == 0) {
                    TextView txtname = (TextView) findViewById(R.id.Task1);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point1);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 1) {
                    TextView txtname = (TextView) findViewById(R.id.Task2);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point2);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 2) {
                    TextView txtname = (TextView) findViewById(R.id.Task3);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point3);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 3) {
                    TextView txtname = (TextView) findViewById(R.id.Task4);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point4);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 4) {
                    TextView txtname = (TextView) findViewById(R.id.Task5);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point5);
                    txtpoint.setText(String.valueOf(point));
                }
                ++count;
            }
        }
        ((EditText) findViewById(R.id.newTask)).setText("");
        ((EditText) findViewById(R.id.newPoints)).setText("");
    }

    public void Go_Home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
