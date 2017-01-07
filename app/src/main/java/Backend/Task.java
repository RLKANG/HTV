package Backend;

/**
 * Created by cheng on 2017/1/7.
 */
public class Task {
    private String name;
    private String note;
    private int point;
    private boolean completed;
    private char repeatWay;//'w' for weekly, 'd' for daily
    public Task(String name, int point){
        this.name=name;
        this.point=point;
        completed=false;
    }
    public int complete(){
        completed = true;
        return point;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public char getRepeatWay() {
        return repeatWay;
    }
    public void setRepeatWay(char repeatWay) {
        this.repeatWay = repeatWay;
    }

}