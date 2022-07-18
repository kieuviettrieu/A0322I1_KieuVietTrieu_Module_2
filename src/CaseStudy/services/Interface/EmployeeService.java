package CaseStudy.services.Interface;

import CaseStudy.models.person.Employee;

public interface EmployeeService extends Service<Employee> {
    void editEmployee();
}
