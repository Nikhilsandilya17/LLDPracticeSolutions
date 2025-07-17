package structural_design_pattern.proxy;

public class EmployeeDaoProxy implements EmployeeDao{
    private EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void createEmployee(String access, EmployeeDao employeeDao) {
        System.out.println("Logging: Attempting to create an employee.");
//        employeeDao.createEmployee();
        System.out.println("Logging: Employee created successfully.");
    }
}
