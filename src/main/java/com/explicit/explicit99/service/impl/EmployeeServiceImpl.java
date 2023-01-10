package com.explicit.explicit99.service.impl;

import com.explicit.explicit99.Repository.EmployeeRepository;
import com.explicit.explicit99.exception.ResourceNotFoundException;
import com.explicit.explicit99.model.Employee;
import com.explicit.explicit99.service.EmployeeService;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save ( employee );
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll ();
    }

    @Override
    public Employee getEmployeeByID(long id) {
        Optional<Employee> employee = employeeRepository.findById ( id );
//        if(employee.isPresent ()){
//            return employee.get ();
//        }
//        else {
//            throw new ResourceNotFoundException ("employee", "id", id );
//        }
        return employeeRepository.findById ( id ).orElseThrow (()-> new ResourceNotFoundException("employee", " id", id ));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // check whether employee exit id Db
        Employee exitEmploye = employeeRepository.findById ( id ).orElseThrow (() ->new ResourceNotFoundException ( "employee","id", id ));
        exitEmploye.setFirstName ( employee.getFirstName () );
        exitEmploye.setLastName ( employee.getLastName () );
        exitEmploye.setEmail ( employee.getEmail () );
        // save exit employee to DB
        employeeRepository.save ( exitEmploye );
        return exitEmploye;
    }

    @Override
    public void deleteEmployee(long id) {

        // check if employee exit in DB or not
        employeeRepository.findById ( id ). orElseThrow (() -> new ResourceNotFoundException ( "employee","id",id ));
        employeeRepository.deleteById ( id );
    }

}
