package singleresponsibilityprinciple.ProblematicCode;

public class Employee {
    private int id;
    private int name;

    public Employee(int id, int name) {
        this.id = id;
        this.name = name;
    }

    public int getSalary(){
        return 1000;
    }

    public void performanceReport(){
        System.out.println("Performance Report");
    }
}
