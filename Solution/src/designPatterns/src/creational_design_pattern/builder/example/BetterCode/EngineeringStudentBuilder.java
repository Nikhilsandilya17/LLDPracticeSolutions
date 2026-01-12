package designPatterns.src.creational_design_pattern.builder.example.BetterCode;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subject = new ArrayList<>();
        subject.add("Sub4");
        subject.add("Sub5");
        subject.add("Sub6");
        this.subjects = subject;
        return this;
    }
}
