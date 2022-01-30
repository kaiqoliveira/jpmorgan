package br.com.api.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.*;




import br.com.api.restapi.Trader;




@RestController
public class financialByTrader {

	@Autowired
	FetchDataService fetchDataService;
	
	@GetMapping("/financialByTrader")
	List<Trader> getUsers(){
		return fetchDataService.findAll();
	}
	
	
}
	
