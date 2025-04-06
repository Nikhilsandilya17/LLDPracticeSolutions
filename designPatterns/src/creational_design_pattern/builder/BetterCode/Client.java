package creational_design_pattern.builder.BetterCode;

public class Client {
    public static void main(String args[]){

        Director director1 = new Director(new EngineeringStudentBuilder());
        Director director2 = new Director(new OtherStudentBuilder());

        Student engineeringStudent = director1.createStudent();
        Student otherStudent = director2.createStudent();

        System.out.println(engineeringStudent.toString());
        System.out.println(otherStudent.toString());


    }

}
