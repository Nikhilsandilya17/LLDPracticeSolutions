package designPatterns.src.structural_design_pattern.proxy;

public interface EmployeeDao {
    void createEmployee(String name, EmployeeDao employeeDao);
}
