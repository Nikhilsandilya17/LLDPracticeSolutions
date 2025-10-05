package designPatterns.src.creational_design_pattern.builder.BetterCode;

import java.util.List;

public class Student {
     int id;
     String name;
     String email;
     String password;
     String fatherName;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.name = studentBuilder.name;
        this.email = studentBuilder.email;
        this.password = studentBuilder.password;
        this.fatherName = studentBuilder.fatherName;
        this.subjects = studentBuilder.subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", subjects=" + subjects +
                '}';
    }






}
