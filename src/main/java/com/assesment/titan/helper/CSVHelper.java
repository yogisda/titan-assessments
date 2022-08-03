package com.assesment.titan.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.assesment.titan.models.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static final String TYPE = "text/csv";

    private CSVHelper(){

    }

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Employee> csvToEmployees(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            List<Employee> employees = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Employee employee = new Employee(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("first_name"),
                        csvRecord.get("last_name"),
                        csvRecord.get("department"),
                        csvRecord.get("birthdate"),
                        csvRecord.get("costcenter")
                );
                employees.add(employee);
            }
            return employees;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}