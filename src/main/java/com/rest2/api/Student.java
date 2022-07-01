package com.rest2.api;

public class Student {
    private int id;
    private String name;
    private String section;
    private String bloodGroup;

    Student(){

    }

    public Student(int id, String name, String section, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
