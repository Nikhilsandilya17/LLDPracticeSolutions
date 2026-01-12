package designPatterns.src.creational_design_pattern.builder.example.BetterCode;

import java.util.List;

public abstract class StudentBuilder {
     int id;
     String name;
     String email;
     String password;
     String fatherName;
    List<String> subjects;

    //SETTER methods of builder class

    public StudentBuilder setId(int id){
        this.id = id;
        return this;
    }

    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public StudentBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public StudentBuilder setPassword(String password){
        this.password = password;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName){
        this.fatherName = fatherName;
        return this;
    }

    public abstract StudentBuilder setSubjects();

    public Student build(){
        return new Student(this);
    }



}
