package com.team.service;

import com.team.domain.PC;
import com.team.domain.*;

import static com.team.service.Data.*;

//import static com.team.service.*.;

public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;

            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment =  createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment =  createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment =  createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }
        }

    }

    /* 获取指定索引上的员工设备*/
    private Equipment createEquipment(int index){
        int option = Integer.parseInt(EQUIPMENTS[index][0]);

        String modalOrName = EQUIPMENTS[index][1];
        switch (option){
            case PC:
                String display = EQUIPMENTS[index][2];
                return new PC(modalOrName, display);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new Notebook(modalOrName, price);
            case PRINTER:
                String type = EQUIPMENTS[index][2];
                return new Printer(modalOrName, type);
        }
        return null;
    }

    public Employee[] getAllEmplyees(){
        return employees;
    }

    // 先不使用 try catch(), 在后续调用此方法时再用， 目前用throws 抛出异常即可
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getId() == id){
                return employees[i];
            }
        }

        throw new TeamException("找不到指定员工。。");
    }
}
