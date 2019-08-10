package pl.sda.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    private static Scanner scanner = new Scanner(System.in);


    public App() {

    }

    public static void main(String[] args ) throws SQLException {
        EmployeeService employeeService = new EmployeeService();
        System.out.println("Wybierz co chcesz zrobic\n" +
                "1. Dodaj Pracownika" +
                "\n2. Wyświetl wszystkich pracownikow");
         Integer input = Integer.parseInt(scanner.nextLine());

         switch (input){
             case 1:
                 employeeService.addEmployee();
                 break;
             case 2:
                 employeeService.printAllEmployees();
                 break;
         }

    }
}
