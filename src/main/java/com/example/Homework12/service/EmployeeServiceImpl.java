package com.example.Homework12.service;

import com.example.Homework12.domain.Employee;
import com.example.Homework12.exception.EmployeeAlreadyAddedException;
import com.example.Homework12.exception.EmployeeNotFoundException;
import com.example.Homework12.exception.EmployeeStorageIsFullException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Joseph Aulsford", 5, 13_000),
            new Employee("Richard Selby", 6, 12_000),
            new Employee("Cheston Furrow", 1, 11_000),
            new Employee("Michael Kane", 3, 9_000),
            new Employee("Harry Maguire", 6, 10_000),
            new Employee("Emma Furrow", 2, 13_000),
            new Employee("Bill Murray", 5, 15_000),
            new Employee("John Lennon", 6, 19_000),
            new Employee("Harvey Oswald", 4, 16_000),
            new Employee("Julia Mill", 4, 20_000),
            new Employee("Ann Potter", 3, 10_000),
            new Employee("Emma Watson", 3, 13_000),
            new Employee("Joshua Hawk", 2, 17_000),
            new Employee("Yoko Lennon", 2, 14_000),
            new Employee("James Dent", 1, 18_000),
            new Employee("Lily Blunt", 1, 21_000)));
    public String menu() {
        return  "1. <b> Получить список всех сотрудников.</b> <br>" +
                "2. <b> Получить список всех сотрудников конкретного департамента.</b> <br>" +
                "3. <b> Добавить сотрудника.</b> <br>" +
                "4. <b> Удалить сотрудника.</b> <br>" +
                "5. <b> Найти сотрудника.</b> <br>";
    }
    // TODO: ввести исключение на случ если массив переполнен - такого сл не будет
    public String addEmployee(String Name, String Surname) {
        String fullName = Name + " " +  Surname;
        // TODO: можно ли занулить зп и департамент?
        //TODO: по умолчанию всех новых сотрудников направляем в 6й департамент со стартовой ЗП 10_000
        if(employees.size() <= 20) {
            if(!employees.contains(fullName)) {
                employees.add(new Employee(fullName, 6, 10_000));
                return "<b>Новый сотрудник успешно добавлен!</b>";
            } else throw new EmployeeAlreadyAddedException();
        } else throw new EmployeeStorageIsFullException();
    }
    public String removeEmployee(String name, String surname) {
        String fullName = name + " " +surname;
        List<Employee> listRemove = employees.stream()
                .filter(employee -> employee.getFullName().equals(fullName))
                .toList();
        if(listRemove.isEmpty()) throw new EmployeeNotFoundException();
        employees.removeAll(listRemove);
        return "<b>Новый сотрудник успешно удален!</b>";
    }
    // TODO: реализован поиск, прописано выбросывание ошибки
    public String searchEmployee(String name, String surname) {
        String fullName = name + " " + surname;
        Employee employeeSearch = employees.stream()
                .filter(employee -> employee.getFullName().equals(fullName))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException());
        return employeeSearch.toString();
    }

    public String getAll(Integer command, Integer department) {
        return switch (command) {
            case 1 -> list(1); //сделать перегрузку, убрать switch в list
            case 2 -> list(2, department);
            default -> throw new RuntimeException("Expected either /menu/2?department=departmentNumber or /menu/1");
        };
    }
    public String list(int command) {
        return employees.toString();
    }
    public String list(int command, int department) {
        List<Employee> searchDepartment = employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
        return searchDepartment.toString();
    }
}
