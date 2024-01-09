package com.example.Homework12.controller;

import com.example.Homework12.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/menu") //общая часть которая будет стоять перед любым запросом
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/{commandNumber}")
    //TODO:http://localhost:8080/menu/2?department=1
    //TODO:http://localhost:8080/menu/1
    public String menu(@PathVariable("commandNumber") Integer command,
                       @RequestParam(value = "department", required = false) Integer department) { //подразумеваем, что department может быть null
        return employeeService.getAll(command, department);
    }
    @GetMapping
    public String menu() {
        return employeeService.menu();
    }
    @GetMapping(path = "/add")
    //TODO:http://localhost:8080/menu/add?name=Richard&surname=Sapogov
    public String addEmployee(@RequestParam ("name") String name,@RequestParam ("surname") String surname) {
        return employeeService.addEmployee(name, surname);
    }
    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam ("name") String name,@RequestParam ("surname") String surname) {
        return employeeService.removeEmployee(name, surname);
    }
    @GetMapping(path = "/search")
    public String searchEmployee(@RequestParam ("name") String name,@RequestParam ("surname") String surname) {
        return employeeService.searchEmployee(name, surname);
    }
}
