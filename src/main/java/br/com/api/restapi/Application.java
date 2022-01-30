package br.com.api.restapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@ComponentScan({"br.com.api.restapi.controllers"})

public class Application {
	

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
       
   
      
        String dbUrl = "jdbc:postgresql://localhost:5433/spring-boot" ;
        String user = "postgres";
        String password = "admin";
        
        try {
        	Connection con = DriverManager.getConnection(dbUrl, user, password);
        	
           
        	
        	
        	String sql = "insert into trader (tradercode, tradername) values ('JDO', 'John Doe'),('JSM', 'John Smith')";
        
        	String sql1 = "insert into trade (price, qty, timestamp) values (25.123456, 1000, current_timestamp),(40.000000, 2000, current_timestamp) ";   
        	
    //    String sql2 = "insert into ordert (ticker) values ('PETR4'), ('ITUB4)";
        
 
        	PreparedStatement pstmt = con.prepareStatement(sql);
        	PreparedStatement pstmt1 = con.prepareStatement(sql1);
     
        	
        //	PreparedStatement pstmt2 = con.prepareStatement(sql2);
        	
        	pstmt.executeUpdate();
        	pstmt1.executeUpdate();
   
        	//pstmt2.executeUpdate();
        	
        	
        } catch (Exception e) {
        	
        }
    
        ///////////////////////////////////////Populando entidade Trader/////////////////
     
    
    }
    

}
