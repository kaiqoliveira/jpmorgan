package br.com.api.restapi.controllers;



import java.io.FileWriter;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
////////////////////////////////////////

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;


@RequestMapping("/CreateNewFile")
@Controller
public class CreateNewFile {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody

	public String aviso() {

		try {
			FileWriter fw = new FileWriter("C:\\temp\\teste22.csv");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/spring-boot", "postgres",
					"admin");
	
			String query = "select trader.tradercode, trader.tradername, trade.qty, trade.price from trader, trade where traderid = tradeid;";
		
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
		
			while (rs.next()) {
				
			
				fw.append('\n');
		
				fw.append(rs.getString(1));
				fw.append(',');
				fw.append(' ');
				fw.append(rs.getString(2));
				fw.append(',');
				fw.append(' ');
				fw.append(rs.getString(3));
				fw.append(',');
				fw.append(' ');
				fw.append(rs.getString(4));
				fw.append(',');
				fw.append(' ');
			
			}
			fw.flush();
			fw.close();
			conn.close();
			System.out.println("CSV File is created successfully.");
		} catch (Exception e) {
			e.printStackTrace();

		
	}return "Arquivo criado com sucesso em seu diretório: C:\temp\teste.csv";

	
	}

}
