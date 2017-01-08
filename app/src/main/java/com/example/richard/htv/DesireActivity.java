package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Backend.Interpreter;

public class DesireActivity extends AppCompatActivity {
    private Interpreter interpreter;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desire);
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
                name = ((EditText) findViewById(R.id.newDesire)).getText().toString();
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
                interpreter.addDesire(name, point);
                if (count == 0) {
                    TextView txtname = (TextView) findViewById(R.id.Desire1);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point1);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 1) {
                    TextView txtname = (TextView) findViewById(R.id.Desire2);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point2);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 2) {
                    TextView txtname = (TextView) findViewById(R.id.Desire3);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point3);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 3) {
                    TextView txtname = (TextView) findViewById(R.id.Desire4);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point4);
                    txtpoint.setText(String.valueOf(point));
                } else if (count == 4) {
                    TextView txtname = (TextView) findViewById(R.id.Desire5);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point5);
                    txtpoint.setText(String.valueOf(point));
                }
                ++count;
            }
        }
        ((EditText) findViewById(R.id.newDesire)).setText("");
        ((EditText) findViewById(R.id.newPoints)).setText("");
    }

    public void Go_Home(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
