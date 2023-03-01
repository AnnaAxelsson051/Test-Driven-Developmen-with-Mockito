package com.example;

import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryStubReturnEmployees implements EmployeeRepository{
    @Override
    public List<Employee> findAll(){
        Employee employee1 = new Employee("1", 20000);
        employee1.setPaid(false);
        Employee employee2 = new Employee("2", 30000);
        employee2.setPaid(true);
        return Arrays.asList(employee1, employee2);
    }

    @Override
    public Employee save(Employee e){
        return null;
    }
}
