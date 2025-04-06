package creational_design_pattern.builder.BetterCode;

import java.util.ArrayList;
import java.util.List;

public class OtherStudentBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subject = new ArrayList<>();
        subject.add("Sub1");
        subject.add("Sub2");
        subject.add("Sub3");
        this.subjects = subject;
        return this;
    }
}
