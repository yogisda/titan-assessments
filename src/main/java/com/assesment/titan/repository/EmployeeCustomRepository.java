package com.assesment.titan.repository;

import com.assesment.titan.models.Employee;

import java.util.List;

public interface EmployeeCustomRepository {
    List<Employee> findByFirstNameAndDepartment(String firstName, String department);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByDepartment(String department);

    List<Employee> findByCostcenter(String costcenter);

}
