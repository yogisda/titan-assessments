package com.assesment.titan.service;
import java.io.IOException;
import java.util.List;

import com.assesment.titan.helper.CSVHelper;
import com.assesment.titan.models.Employee;
import com.assesment.titan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
    @Autowired
    private EmployeeRepository repository;
    public void save(MultipartFile file) {
        try {
            List<Employee> employees = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(employees);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
    public List<Employee> getAllTutorials() {
        return repository.findAll();
    }
}
