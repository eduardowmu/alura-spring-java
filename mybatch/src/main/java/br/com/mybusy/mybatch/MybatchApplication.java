package br.com.mybusy.mybatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class MybatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatchApplication.class, args);
	}

}
