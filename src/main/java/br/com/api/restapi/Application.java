package br.com.api.restapi;

import javax.persistence.Access;
import javax.persistence.AccessType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.api.restapi.services.FetchDataService;



/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@ComponentScan({"br.com.api.restapi"})
@Access(AccessType.FIELD)
public class Application {
	
    @Autowired
    FetchDataService service ;

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
        
    }
}
