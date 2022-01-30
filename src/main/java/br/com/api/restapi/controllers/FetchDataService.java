package br.com.api.restapi.controllers;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.api.restapi.Trader;


@Repository
public interface FetchDataService  extends JpaRepository<Trader, Integer>{
	
	@Override
	List<Trader> findAll();
	//

	
}
