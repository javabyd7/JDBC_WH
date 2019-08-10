package pl.sda.jdbc;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public App() {

    }

    public static void main(String[] args ) throws SQLException {
        Connection connection = DbConnector.getConnection();


        Statement statement =  null;


        try {

            statement = connection.createStatement();
            String insert = "insert  into " +
                    "`employees`(`employeeNumber`,`lastName`,`firstName`,`extension`,`email`,`officeCode`,`reportsTo`,`jobTitle`) " +
                    "values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1,1999);
            preparedStatement.setString(2,"Karolczak");
            preparedStatement.setString(3,"Mariusz");
            preparedStatement.setString(4,"exteee");
            preparedStatement.setString(5,"email@gg.com");
            preparedStatement.setInt(6,6);
            preparedStatement.setInt(7,1002);
            preparedStatement.setString(8,"jobbing");
            preparedStatement.execute();
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
        }finally {
            connection.close();
        }
    }
}
