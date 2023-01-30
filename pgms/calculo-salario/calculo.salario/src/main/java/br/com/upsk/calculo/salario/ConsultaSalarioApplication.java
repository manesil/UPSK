package br.com.upsk.calculo.salario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

//Aplicação principal

@SpringBootApplication
public class ConsultaSalarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaSalarioApplication.class, args);
	}

}
