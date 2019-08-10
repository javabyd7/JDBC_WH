package pl.sda.jdbc;

import java.sql.*;
import java.util.Scanner;

public class EmployeeService {

    private Connection connection = DbConnector.getConnection();
    private Statement statement = null;
    private Scanner scanner = new Scanner(System.in);

    public void addEmployee(){

        System.out.println("Podaj ID pracownika:");
        Integer employeeNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj Imie pracownika:");
        String firstName = scanner.nextLine();
        System.out.println("Podaj Nazwisko pracownika:");
        String lastName = scanner.nextLine();
        System.out.println("Podaj Extension pracownika:");
        String extension = scanner.nextLine();
        System.out.println("Podaj Email pracownika:");
        String email = scanner.nextLine();
        System.out.println("Podaj Office Code pracownika:");
        Integer officeCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj Reports to pracownika:");
        Integer reportsTo = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj Job Title pracownika:");
        String jobTitle = scanner.nextLine();
        try {
            statement = connection.createStatement();
            String insert = "insert  into " +
                    "`employees`(`employeeNumber`,`lastName`,`firstName`,`extension`,`email`,`officeCode`,`reportsTo`,`jobTitle`) " +
                    "values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1,employeeNumber);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,firstName);
            preparedStatement.setString(4,extension);
            preparedStatement.setString(5,email);
            preparedStatement.setInt(6,officeCode);
            preparedStatement.setInt(7,reportsTo);
            preparedStatement.setString(8,jobTitle);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllEmployees(){

        try {
            statement = connection.createStatement();
            String sql = "select * from employees";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println(resultSet);
            while (resultSet.next()){
                System.out.println("Imie i Nazwisko "+resultSet.getString("firstName")+ " " +
                        resultSet.getString("lastName")+
                        " Email: "+resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
