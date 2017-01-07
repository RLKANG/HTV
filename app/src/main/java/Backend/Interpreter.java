package Backend;

import java.util.ArrayList;

/**
 * Created by cheng on 2017/1/7.
 */

public class Interpreter {
    private ArrayList<Task> tasks;
    private ArrayList<Task> pastTasks;
    private ArrayList<Desire> pastDesires;
    private ArrayList<Desire> desires;
    private int point;
    public Interpreter(){
        tasks=new ArrayList<Task>();
        desires=new ArrayList<Desire>();
        point=0;
    }
    public void addTask(String name, int point){
        Task task =new Task(name, point);
        tasks.add(task);
    }
    public void completeTask(int index){
        point+=tasks.get(index).complete();
        pastTasks.add(tasks.get(index));
        tasks.remove(index);
    }
    public void satisfiedDesire(int index){
        point-=desires.get(index).satisfied();
        if(desires.get(index).getTimes()<=0){
            desires.remove(index);
        }
    }
    public void addDesire(String name,int point){
        Desire desire = new Desire(name, point);
        desires.add(desire);
    }
}
