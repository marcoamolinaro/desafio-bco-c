package br.com.carrefour.fluxocaixaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class FluxoCaixaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FluxoCaixaServiceApplication.class, args);
	}

}
