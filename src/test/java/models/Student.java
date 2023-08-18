package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private String location;
    private String phone;
    private List<String> course;


    public Student(String name, String location, String phone, ArrayList<String> course) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.course = course;
    }

    public Student() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }


}
