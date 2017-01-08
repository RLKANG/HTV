package com.example.richard.htv;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                    td = false;
                    view_tasks();
                }
                else {
                    if ((interpreter.getPoint() - interpreter.getDesire(0).getPoint()) >= 0) {
                        interpreter.satisfiedDesire(0);
                        --desire_count;
                    }
                    td = true;
                    view_desires();
                }
                TextView tv = (TextView) findViewById(R.id.NumPoints);
                int p = interpreter.getPoint();
                tv.setText(String.valueOf(p));
                uncheck(0);
            }
        });
        CheckBox cb2 = (CheckBox) findViewById(R.id.Task2);
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setInvisible();
                if (td) {
                    interpreter.completeTask(1);
                    --task_count;
                    td = false;
                    view_tasks();
                }
                else {
                    if ((interpreter.getPoint() - interpreter.getDesire(0).getPoint()) >= 0) {
                        interpreter.satisfiedDesire(1);
                        --desire_count;
                    }
                    td = true;
                    view_desires();
                }
                TextView tv = (TextView) findViewById(R.id.NumPoints);
                int p = interpreter.getPoint();
                tv.setText(String.valueOf(p));
                uncheck(1);
            }
        });
        CheckBox cb3 = (CheckBox) findViewById(R.id.Task3);
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setInvisible();
                if (td) {
                    interpreter.completeTask(2);
                    --task_count;
                    td = false;
                    view_tasks();
                }
                else {
                    if ((interpreter.getPoint() - interpreter.getDesire(0).getPoint()) >= 0) {
                        interpreter.satisfiedDesire(2);
                        --desire_count;
                    }
                    td = true;
                    view_desires();
                }
                TextView tv = (TextView) findViewById(R.id.NumPoints);
                int p = interpreter.getPoint();
                tv.setText(String.valueOf(p));
                uncheck(2);
            }
        });
        CheckBox cb4 = (CheckBox) findViewById(R.id.Task4);
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setInvisible();
                if (td) {
                    interpreter.completeTask(3);
                    --task_count;
                    td = false;
                    view_tasks();
                }
                else {
                    if ((interpreter.getPoint() - interpreter.getDesire(0).getPoint()) >= 0) {
                        interpreter.satisfiedDesire(3);
                        --desire_count;
                    }
                    td = true;
                    view_desires();
                }
                TextView tv = (TextView) findViewById(R.id.NumPoints);
                int p = interpreter.getPoint();
                tv.setText(String.valueOf(p));
                uncheck(3);
            }
        });
        CheckBox cb5 = (CheckBox) findViewById(R.id.Task5);
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setInvisible();
                if (td) {
                    interpreter.completeTask(4);
                    --task_count;
                    td = false;
                    view_tasks();
                }
                else {
                    if ((interpreter.getPoint() - interpreter.getDesire(0).getPoint()) >= 0) {
                        interpreter.satisfiedDesire(4);
                        --desire_count;
                    }
                    td = true;
                    view_desires();
                }
                TextView tv = (TextView) findViewById(R.id.NumPoints);
                int p = interpreter.getPoint();
                tv.setText(String.valueOf(p));
                uncheck(4);
            }
        });
        Button b1 = (Button) findViewById(R.id.TasksButton);
        b1.setBackgroundColor(Color.GREEN);
        Button b2 = (Button) findViewById(R.id.DesireShopButton);
        b2.setBackgroundColor(Color.GRAY);
    }

    public void uncheck (int i) {
        if (i == 0) {
            CheckBox cb = (CheckBox) findViewById(R.id.Task1);
            cb.setChecked(false);
        }
        if (i == 1) {
            CheckBox cb = (CheckBox) findViewById(R.id.Task2);
            cb.setChecked(false);
        }
        if (i == 2) {
            CheckBox cb = (CheckBox) findViewById(R.id.Task3);
            cb.setChecked(false);
        }
        if (i == 3) {
            CheckBox cb = (CheckBox) findViewById(R.id.Task4);
            cb.setChecked(false);
        }
        if (i == 4) {
            CheckBox cb = (CheckBox) findViewById(R.id.Task5);
            cb.setChecked(false);
        }
    }

    public void popUp (View view) {
        final int n = getindex(view);
        if (td) {
            if (task_count <= n) {
                return;
            }
        }
        else {
            if (desire_count <= n) {
                return;
            }
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Write Note");
        final EditText input = new EditText(this);
        alert.setView(input);
        if (td) {
            input.setText(interpreter.getTask(n).getNote());
        }
        else {
            input.setText(interpreter.getDesire(n).getNote());
        }
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString();
                if (td) {
                    interpreter.getTask(n).setNote(value);
                }
                else {
                    interpreter.getDesire(n).setNote(value);
                }
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

    public int getindex(View view) {
        int ind;
        if (view.getId() == R.id.Button1) {
            ind = 0;
        } else if (view.getId() == R.id.Button2) {
            ind = 1;
        } else if (view.getId() == R.id.Button3) {
            ind = 2;
        } else if (view.getId() == R.id.Button4) {
            ind = 3;
        } else {
            ind = 4;
        }
        return ind;
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
        else {
            Toast.makeText(this, getString(R.string.max), Toast.LENGTH_SHORT).show();
        }
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
        else {
            Toast.makeText(this, getString(R.string.max), Toast.LENGTH_SHORT).show();
        }
        ((EditText) findViewById(R.id.newTD)).setText("");
        ((EditText) findViewById(R.id.newPoints)).setText("");
    }

    public void viewTasks(View view) {
        view_tasks();
    }

    public void view_tasks () {
        Button b1 = (Button) findViewById(R.id.TasksButton);
        b1.setBackgroundColor(Color.GREEN);
        Button b2 = (Button) findViewById(R.id.DesireShopButton);
        b2.setBackgroundColor(Color.GRAY);
        if (!td) {
            TextView td = (TextView) findViewById(R.id.TD);
            String s = "Task: ";
            td.setText(s);
            setInvisible();
            System.out.println(task_count);
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

    public void viewDesires(View view) {
        view_desires();
    }

    public void view_desires () {
        Button b1 = (Button) findViewById(R.id.TasksButton);
        b1.setBackgroundColor(Color.GRAY);
        Button b2 = (Button) findViewById(R.id.DesireShopButton);
        b2.setBackgroundColor(Color.GREEN);
        if (td) {
            TextView td = (TextView) findViewById(R.id.TD);
            String s = "Desire: ";
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
