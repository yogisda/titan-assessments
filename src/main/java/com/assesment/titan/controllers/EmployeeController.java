package com.assesment.titan.controllers;

import com.assesment.titan.models.Employee;
import com.assesment.titan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        return employeeData.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/employees/{firstname}/{department}")
    public List<Employee> findByFirstnameAndDepartment(@PathVariable("firstname") String firstname,
                                                       @PathVariable("department") String department) {


        return employeeRepository.findByFirstNameAndDepartment(firstname, department);
    }

    @GetMapping("/employees/firstname/{firstname}")
    public List<Employee> findByFirstName(@PathVariable("firstname") String firstname) {


        return employeeRepository.findByFirstName(firstname);
    }

    @GetMapping("/employees/lastname/{lastname}")
    public List<Employee> findByLastname(@PathVariable("lastname") String lastname) {


        return employeeRepository.findByLastName(lastname);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> findByDepartment(@PathVariable("department") String department) {


        return employeeRepository.findByDepartment(department);
    }

    @GetMapping("/employees/costcenter/{costcenter}")
    public List<Employee> findByCostcenter(@PathVariable("costcenter") String costcenter) {


        return employeeRepository.findByCostcenter(costcenter);
    }


}
