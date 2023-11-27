package br.com.mac0472.planejamentoorcamentario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) // test local without authenticating
public class PlanejamentoOrcamentarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanejamentoOrcamentarioApplication.class, args);
	}

}