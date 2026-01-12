package designPatterns.src.creational_design_pattern.builder.example.ProblematicCode;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String email;
    private String password;
    private String fatherName;
    private String motherName;
    private String address;
    List<String> subjects;

    public Student(int id, String name, String email, String fatherName, String address, String motherName, String password, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.fatherName = fatherName;
        this.address = address;
        this.motherName = motherName;
        this.password = password;
        this.subjects = subjects;
    }

    public Student(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    //This would give error as signature is same
    //Also we cant create multiple constructors if we want Student to be created with specific fields

//    public Student(int id, String name, String fatherName){
//        this.id = id;
//        this.name = name;
//        this.fatherName = fatherName;
//    }

    //---BUILDER PATTERN



}
