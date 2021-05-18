package Homework.prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
//        Clone clone = new Clone();
//        clone.addName("姐姐");
//        try {
//            Clone copy = clone.clone();
//            System.out.println(clone.getName(0));
//            System.out.println(copy.getName(0));
//            clone.updateName(0, "弟弟");
//            System.out.println(clone.getName(0));
//            System.out.println(copy.getName(0));
//        }
//        catch (CloneNotSupportedException e){
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        InfoWarehouse warehouse = new InfoWarehouse();
        Student.collegeNo.put("软件学院软件工程", "243");
        Student.collegeNo.put("外文学院英语", "120");
        List<Student> students = new ArrayList<>(8);
        students.add(new Student(2018, 1, "软件学院", "软件工程", "陈志强"));
        students.add(new Student(2018, 1, "外文学院", "英语", "陆小丰"));
        warehouse.addStudentInfo("2018级软件学院软件工程", students.get(0));
        warehouse.addStudentInfo("2018级外文学院英语", students.get(1));
        students.add(warehouse.createStudent("林明康", "2018级软件学院软件工程"));
        students.add(warehouse.createStudent("刘泊轩", "2018级外文学院英语"));
        students.add(warehouse.createStudent("沈星南", "2018级软件学院软件工程"));
        students.add(warehouse.createStudent("张子陶", "2018级外文学院英语"));
        for (Student student : students){
            System.out.println(student.toString());
        }
    }
}
