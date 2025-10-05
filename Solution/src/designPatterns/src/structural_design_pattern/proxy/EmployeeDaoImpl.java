package designPatterns.src.structural_design_pattern.proxy;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void createEmployee(String access, EmployeeDao employeeDao) {
        System.out.println("Employee created");
    }
}
