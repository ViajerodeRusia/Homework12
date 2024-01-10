package com.example.Homework12.service;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    String getAll(Integer command, Integer department);
    String menu();
    String addEmployee(String name, String surname);
    String removeEmployee(String name, String surname);
    String searchEmployee(String name, String surname);
}
