package Homework.prototype;

import java.util.HashMap;

public class Student implements Cloneable {
    private Integer year;
    private Integer number;
    private String college;
    private String major;
    private String name;
    public final static HashMap<String, String> collegeNo = new HashMap<>();
    public final static HashMap<String, String> majorNo = new HashMap<>();

    public Student() {
    }

    public Student(Integer year, Integer number,
                   String college, String major, String name) {
        this.year = year;
        this.number = number;
        this.college = college;
        this.major = major;
        this.name = name;
    }

    @Override
    public Student clone(){
        try {
            super.clone();
            Student copy = new Student();
            copy.year = this.year;
            copy.number = this.number + 1;
            copy.college = this.college;
            copy.major = this.major;
            copy.name = this.name;
            return copy;
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return college + major + "专业的" + year + "级的" + name + ", 学号：" + getStudentNo();
    }

    public String getStudentNo(){
        String college = collegeNo.get(this.college+this.major);
        if(college == null){
            college = "000";
        }
        String se = this.number.toString();
        if (this.number < 10){
            se = "00" + se;
        }
        else if (this.number < 100){
            se = "0" + se;
        }
        return college + year + "2203" + se;
    }
}
