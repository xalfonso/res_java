package entity;

/**
 * @author Msc. Ing. Eduardo Alfonso Sanchez eddie.alfonso@gmail.com
 *         Date & Time: 6/7/2017 16:45 */
public class Student {

    private String name;
    private int position;
    private int age;
    private float avg;

    public Student(String name, int position, int age, float avg) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.avg = avg;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}
