package com.explicit.explicit99.controller;

import com.explicit.explicit99.model.Employee;
import com.explicit.explicit99.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // create post employee rest api
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee ( employee ),HttpStatus.CREATED);

    }

    // create get all employee rest api
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getEmployee ();
    }

    // build Get employee by ID rest api


    // http://localhost:8080/api/employees/1
    //@GetMapping({"id"})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee> ( employeeService.getEmployeeByID ( employeeId ), HttpStatus.OK );
    }

    // Build update rest api


    //@PutMapping({"id"})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee> ( employeeService.updateEmployee ( employee,id ), HttpStatus.OK );

    }

    // Delete Rest API
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<String> deleteByID(@PathVariable("id") long id){
     employeeService.deleteEmployee ( id );
     return new ResponseEntity<String> ("delete successful", HttpStatus.OK );

    }
}
