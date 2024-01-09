package com.example.Homework12.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Employee {
    private String fullName;
    private int department;
    private double wage;
    @EqualsAndHashCode.Exclude
    //не будет включать в Equals
    private int number;
    public Employee(String fullName, int department, double wage) {
        this.fullName = fullName;
        this.department = department;
        this.wage = wage;
        this.number = Counter.getAndIncrement();
    }

    @Override
    public String toString() {
        return "<b> Employee n."+ number + "</b>" +
                "<br> fullName= " + fullName +
                ", <br> department=" + department +
                ", <br> wage=" + wage +
                ", <br> number=" + number +"<br>";
    }
}