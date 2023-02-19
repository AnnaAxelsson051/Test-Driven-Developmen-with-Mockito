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
//only one emp has been paid so we should get a list with only 1 when
        //setpaid in empmanager

        List<Employee> employeeList = Arrays.asList(employee1, employee2);

        EmployeeManager employeeManager = new EmployeeManager(new EmployeeRepositoryStubReturnEmployees(), new DummyBankService());

//bc emp manager constructor takes emp repo och bankservice ger vi den en stub och en mock av dem
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

        EmployeeRepository employeeRepositoryStub = mock(EmployeeRepository.class);  //skapar mocken emp repository
        //returnerar en fake instans av
        //emprepostub kommer åt alla metoder som finns i emprepo stub
        //man fått en instans av emp repo men den har fakebeteende man kan kontrollera vad den kan returnera mm
        Mockito.when(employeeRepositoryStub.findAll()).thenReturn(allEmployees);  //här anv den används som stub
        //när findall anropas return all emps
        EmployeeManager employeeManager = new EmployeeManager(employeeRepositoryStub, new DummyBankService());
        //ger stubben till empmanager och dummy (som gör inget) för att konstructor behöver det
        //stub gör det man berättat tex returnera false, dummy är bara där för att få veta av programmerarar vad de ska göra
        Assertions.assertEquals(Collections.singletonList(employee1),
                employeeManager.getAllNotPaidEmployees(), "Should return only not paid employees");
        //singleton är en hjälpmetod som java använder för att returnera en lista med ett ite
        //assert jämför listan man får o det som get all not paid emps returnerar tillbaka
        Mockito.verify(employeeRepositoryStub, times(1)).findAll();  //här anv som mock
        //verifiera att den kallats en gång

    }

}
