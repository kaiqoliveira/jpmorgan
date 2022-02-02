package br.com.api.restapi.controllers;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.restapi.model.dto.ReturnJson;
import br.com.api.restapi.services.FetchDataService;


@RestController 
public class TradeController {

	
	@Autowired
	FetchDataService fetchDataService;
	
	@GetMapping("/financialByTrader")
	
	List<ReturnJson> getUsers(){
		
		return fetchDataService.findAll();
	
		
		
	} 
	
	@GetMapping("/CreateNewFile")
	@ResponseBody
	public String createCsv() {

		try {
			FileWriter fw = new FileWriter("C:\\temp\\teste22.csv");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/spring-boot", "postgres",
					"admin");
	
			
		 String query = "SELECT \r\n"
		 		+ "    trader.tradercode, trader.tradername,\r\n"
		 		+ "    orderT.orderId, orderT.ticker,\r\n"
		 		+ "     trade.quantity, trade.price\r\n"
		 		+ "FROM\r\n"
		 		+ "    trader LEFT JOIN ordert orderT ON trader.tradercode = orderT.traderid \r\n"
		 		+ "    LEFT JOIN trade ON orderT.orderId = trade.orderid;";
		 

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
		
			while(rs.next()) {
			
			
				fw.append("\n");
				fw.append(rs.getString(1));
				fw.append(", ");
				fw.append(rs.getString(2));
				fw.append(", ");
				fw.append(rs.getString(3));
				fw.append(", ");
				fw.append(rs.getString(4));
				fw.append(", ");
				fw.append(rs.getString(5));
				fw.append(", ");
				fw.append(rs.getString(6));
				
				
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
