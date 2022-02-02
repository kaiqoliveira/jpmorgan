package br.com.api.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.restapi.model.Trade;


@Repository
public interface FetchDataRepository  extends JpaRepository<Trade, Integer>{
	
	@Override
	List<Trade> findAll();
	//
}
