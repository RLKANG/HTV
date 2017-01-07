package Backend;

/**
 * Created by cheng on 2017/1/7.
 */


public class Desire {
    private String name;
    private String note;
    private int point;
    private boolean infinity;
    private int times;
    public Desire(String name, int point){
        this.name=name;
        this.point=point;
        times=1;
    }
    public int satisfied(){
        times-=1;
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
    public boolean isInfinity() {
        return infinity;
    }
    public void setInfinity(boolean infinity) {
        this.infinity = infinity;
    }
    public int getTimes() {
        return times;
    }
    public void setTimes(int times) {
        this.times = times;
    }

}
