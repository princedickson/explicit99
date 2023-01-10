package com.explicit.explicit99.service;

import com.explicit.explicit99.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getEmployee();
    Employee getEmployeeByID(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
