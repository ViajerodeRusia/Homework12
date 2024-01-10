package com.example.Homework12.check;

import com.example.Homework12.domain.Employee;
import com.example.Homework12.exception.EmployeeStorageIsFullException;

import java.util.List;

public class StorageCheck {
    public static boolean isStorageFull(List<Employee> employees) {
        if(employees.size() < 20) {
            return true;
        } else throw new EmployeeStorageIsFullException();
    }
}
