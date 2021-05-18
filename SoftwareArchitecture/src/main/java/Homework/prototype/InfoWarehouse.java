package Homework.prototype;

import java.util.HashMap;

public class InfoWarehouse {
    private final HashMap<String, Cloneable> map;
    public InfoWarehouse(){
        map = new HashMap<>();
    }
    public void addStudentInfo(String key, Cloneable stu){
        map.put(key, stu);
    }
    public Student createStudent(String name, String key){
        Student student = (Student)map.get(key);
        if (student == null){
            return null;
        }
        Student copy = student.clone();
        copy.setName(name);
        map.put(key, copy);
        return copy;
    }
}
