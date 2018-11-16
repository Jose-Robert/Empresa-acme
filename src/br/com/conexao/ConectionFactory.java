package br.com.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
    
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5434/acme", "postgres", "sql2014");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
