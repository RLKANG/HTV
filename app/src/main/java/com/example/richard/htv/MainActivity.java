package com.example.richard.htv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Backend.Interpreter;
import Backend.Task;
import Backend.Desire;

public class MainActivity extends AppCompatActivity {
    private Interpreter interpreter;
    private int task_count = 0;
    private int desire_count = 0;
    private int num_points = 0;
    private boolean td = true; //true for task, false for desire
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        //if(intent.getExtras().containsKey("interpreter")) {
            interpreter = (Interpreter) intent.getSerializableExtra("interpreter");
        //}else {
            interpreter = new Interpreter();
        //}
        CheckBox cb1 = (CheckBox) findViewById(R.id.Task1);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setInvisible();
                if (td) {
                    interpreter.completeTask(0);
                    --task_count;
                    viewTasks();
                }
                else {
                    interpreter.satisfiedDesire(0);
                    --desire_count;
                    viewDesires();
                }
                TextView tv = (TextView) findViewById(R.id.NumPoints);
                int p = interpreter.getPoint();
                tv.setText(String.valueOf(p));
            }
        });
        CheckBox cb2 = (CheckBox) findViewById(R.id.Task2);
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("2");
            }
        });
        CheckBox cb3 = (CheckBox) findViewById(R.id.Task3);
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("3");
            }
        });
        CheckBox cb4 = (CheckBox) findViewById(R.id.Task4);
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("4");
            }
        });
        CheckBox cb5 = (CheckBox) findViewById(R.id.Task5);
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                System.out.println("5");
            }
        });
    }


    public void Set (View view) {
    }

    public void Add (View view) {
        if (td) {
            add_task(view);
        }
        else {
            add_desire(view);
        }
    }

    public void add_task (View view) {
        if (task_count < 5) {
            String name = "";
            try {
                name = ((EditText) findViewById(R.id.newTD)).getText().toString();
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
                if (task_count == 0) {
                    TextView txtname = (TextView) findViewById(R.id.Task1);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point1);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (task_count == 1) {
                    TextView txtname = (TextView) findViewById(R.id.Task2);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point2);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (task_count == 2) {
                    TextView txtname = (TextView) findViewById(R.id.Task3);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point3);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (task_count == 3) {
                    TextView txtname = (TextView) findViewById(R.id.Task4);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point4);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (task_count == 4) {
                    TextView txtname = (TextView) findViewById(R.id.Task5);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point5);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                }
                ++task_count;
            }
        }
        //else toast??
        ((EditText) findViewById(R.id.newTD)).setText("");
        ((EditText) findViewById(R.id.newPoints)).setText("");
    }

    public void add_desire (View view) {
        if (desire_count < 5) {
            String name = "";
            try {
                name = ((EditText) findViewById(R.id.newTD)).getText().toString();
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
                if (desire_count == 0) {
                    TextView txtname = (TextView) findViewById(R.id.Task1);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point1);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (desire_count == 1) {
                    TextView txtname = (TextView) findViewById(R.id.Task2);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point2);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (desire_count == 2) {
                    TextView txtname = (TextView) findViewById(R.id.Task3);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point3);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (desire_count == 3) {
                    TextView txtname = (TextView) findViewById(R.id.Task4);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point4);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                } else if (desire_count == 4) {
                    TextView txtname = (TextView) findViewById(R.id.Task5);
                    txtname.setVisibility(View.VISIBLE);
                    txtname.setText(name);
                    TextView txtpoint = (TextView) findViewById(R.id.Point5);
                    txtpoint.setVisibility(View.VISIBLE);
                    txtpoint.setText(String.valueOf(point));
                }
                ++desire_count;
            }
        }
        //else toast??
        ((EditText) findViewById(R.id.newTD)).setText("");
        ((EditText) findViewById(R.id.newPoints)).setText("");
    }

    public void viewTasks () {
        if (!td) {
            TextView td = (TextView) findViewById(R.id.TD);
            String s = "Task";
            td.setText(s);
            setInvisible();
            if (task_count > 0) {
                Task t = interpreter.getTask(0);
                TextView txtname = (TextView) findViewById(R.id.Task1);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(t.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point1);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(t.getPoint()));
            } if (task_count > 1) {
                Task t = interpreter.getTask(1);
                TextView txtname = (TextView) findViewById(R.id.Task2);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(t.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point2);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(t.getPoint()));
            } if (task_count > 2) {
                Task t = interpreter.getTask(2);
                TextView txtname = (TextView) findViewById(R.id.Task3);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(t.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point3);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(t.getPoint()));
            } if (task_count > 3) {
                Task t = interpreter.getTask(3);
                TextView txtname = (TextView) findViewById(R.id.Task4);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(t.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point4);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(t.getPoint()));
            } if (task_count > 4) {
                Task t = interpreter.getTask(4);
                TextView txtname = (TextView) findViewById(R.id.Task5);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(t.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point5);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(t.getPoint()));
            }
        }
        td = true;
    }

    public void viewDesires () {
        if (td) {
            TextView td = (TextView) findViewById(R.id.TD);
            String s = "Desire";
            td.setText(s);
            setInvisible();
            if (desire_count > 0) {
                Desire d = interpreter.getDesire(0);
                TextView txtname = (TextView) findViewById(R.id.Task1);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(d.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point1);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(d.getPoint()));
            } if (desire_count > 1) {
                Desire d = interpreter.getDesire(1);
                TextView txtname = (TextView) findViewById(R.id.Task2);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(d.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point2);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(d.getPoint()));
            } if (desire_count > 2) {
                Desire d = interpreter.getDesire(2);
                TextView txtname = (TextView) findViewById(R.id.Task3);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(d.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point3);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(d.getPoint()));
            } if (desire_count > 3) {
                Desire d = interpreter.getDesire(3);
                TextView txtname = (TextView) findViewById(R.id.Task4);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(d.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point4);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(d.getPoint()));
            } if (desire_count > 4) {
                Desire d = interpreter.getDesire(4);
                TextView txtname = (TextView) findViewById(R.id.Task5);
                txtname.setVisibility(View.VISIBLE);
                txtname.setText(d.getName());
                TextView txtpoint = (TextView) findViewById(R.id.Point5);
                txtpoint.setVisibility(View.VISIBLE);
                txtpoint.setText(String.valueOf(d.getPoint()));
            }
        }
        td = false;
    }

    void setInvisible() {
        TextView txtname1 = (TextView) findViewById(R.id.Task1);
        txtname1.setVisibility(View.INVISIBLE);
        TextView txtpoint1 = (TextView) findViewById(R.id.Point1);
        txtpoint1.setVisibility(View.INVISIBLE);
        TextView txtname2 = (TextView) findViewById(R.id.Task2);
        txtname2.setVisibility(View.INVISIBLE);
        TextView txtpoint2 = (TextView) findViewById(R.id.Point2);
        txtpoint2.setVisibility(View.INVISIBLE);
        TextView txtname3 = (TextView) findViewById(R.id.Task3);
        txtname3.setVisibility(View.INVISIBLE);
        TextView txtpoint3 = (TextView) findViewById(R.id.Point3);
        txtpoint3.setVisibility(View.INVISIBLE);
        TextView txtname4 = (TextView) findViewById(R.id.Task4);
        txtname4.setVisibility(View.INVISIBLE);
        TextView txtpoint4 = (TextView) findViewById(R.id.Point4);
        txtpoint4.setVisibility(View.INVISIBLE);
        TextView txtname5 = (TextView) findViewById(R.id.Task5);
        txtname5.setVisibility(View.INVISIBLE);
        TextView txtpoint5 = (TextView) findViewById(R.id.Point5);
        txtpoint5.setVisibility(View.INVISIBLE);
    }

    /*public void viewTasks(View view){
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("interpreter", interpreter);
        startActivity(intent);
    }
    public void viewDesires(View view){
        Intent intent=new Intent(this, DesireActivity.class);
        intent.putExtra("interpreter",interpreter);
        startActivity(intent);
    }*/

}
