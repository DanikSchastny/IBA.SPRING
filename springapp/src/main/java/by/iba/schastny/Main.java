package by.iba.schastny;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Minsk&useSSL=false";
        String username = "root";
        String password = "cef_a615ZFC62";

        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connection created!");
        }
        catch (SQLException e){
            System.out.println("Соси давай");
        }
    }
}
