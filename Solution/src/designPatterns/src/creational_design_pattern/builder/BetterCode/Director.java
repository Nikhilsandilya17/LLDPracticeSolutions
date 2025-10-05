package designPatterns.src.creational_design_pattern.builder.BetterCode;

public class Director {
    //Client will call this class methods and create objects for Engineering or Other students

    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent(){
        if(studentBuilder instanceof EngineeringStudentBuilder){
            return createEngineeringStudent();
        }
        else if(studentBuilder instanceof  OtherStudentBuilder){
            return createOtherStudent();
        }
        return null;
    }

    private Student createOtherStudent() {
        return studentBuilder.setId(1).setName("Nikhil").setEmail("nikhilsandilya1702@gmail.com").setFatherName("Hello").setPassword("1234").setSubjects().build();
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setId(2).setName("Anand").setEmail("anand@gmail.com").setPassword("1234").setFatherName("Hello_1").setSubjects().build();
    }


}
