package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class EmployeeManagerTest {

    @Test
    public void testReturnNotPaidShouldReturnOnlyNotPaid() {
        Employee employee1 = new Employee("1", 20000);
        employee1.setPaid(false);
        Employee employee2 = new Employee("2", 30000);
        employee2.setPaid(true);

        List<Employee> employeeList = Arrays.asList(employee1, employee2);

        EmployeeManager employeeManager = new EmployeeManager(new EmployeeRepositoryStubReturnEmployees(), new DummyBankService());

        Assertions.assertEquals(Arrays.asList(employee1),
                employeeManager.getAllNotPaidEmployees(), "should return only not paid employees");
    }

    @Test
    public void testReturnNotPaidWithMockito() {
        Employee employee1 = new Employee("1", 20000);
        employee1.setPaid(false);
        Employee employee2 = new Employee("2", 30000);
        employee2.setPaid(true);
        List<Employee> allEmployees = Arrays.asList(employee1, employee2);

        EmployeeRepository employeeRepositoryStub = mock(EmployeeRepository.class);  
    
        Mockito.when(employeeRepositoryStub.findAll()).thenReturn(allEmployees);  
        EmployeeManager employeeManager = new EmployeeManager(employeeRepositoryStub, new DummyBankService());
        
        Assertions.assertEquals(Collections.singletonList(employee1),
                employeeManager.getAllNotPaidEmployees(), "Should return only not paid employees");

        Mockito.verify(employeeRepositoryStub, times(1)).findAll();  

    }

}
