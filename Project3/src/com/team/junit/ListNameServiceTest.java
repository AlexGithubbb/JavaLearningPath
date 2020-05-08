package com.team.junit;

import com.team.domain.Employee;
import com.team.service.NameListService;
import org.junit.Test;

public class ListNameServiceTest extends NameListService {

    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmplyees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){

    }
}
