package br.com.api.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.restapi.model.dto.ReturnJson;
import br.com.api.restapi.services.CreateCsvService;
import br.com.api.restapi.services.FetchDataService;

@RestController
public class TradeController {

	@Autowired
	FetchDataService fetchDataService;

	@Autowired
	CreateCsvService csvService;
	
	@GetMapping("/financialByTrader")
	List<ReturnJson> getUsers() {

		return fetchDataService.getTotal();

	}

	@GetMapping("/CreateNewFile")
	@ResponseBody
	public String createCsv() {

		String response = csvService.createCsv();
		return "Arquivo criado com sucesso em seu diretório: " + response;

	}

}
