package com.example.Homework12.check;

import com.example.Homework12.domain.Employee;
import com.example.Homework12.exception.EmployeeAlreadyAddedException;

import java.util.List;

public class FullNameCheck {
    public static boolean isClone(String fullname, List<Employee> employees) {
        for (Employee employee : employees) {
           if(employee.getFullName().equals(fullname)) throw new EmployeeAlreadyAddedException();
        }
        return true;
    }
}
