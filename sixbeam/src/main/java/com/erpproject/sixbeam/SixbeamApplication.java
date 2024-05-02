package com.erpproject.sixbeam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Paths;

@SpringBootApplication
public class  SixbeamApplication {
	public static void main(String[] args) {
		SpringApplication.run(SixbeamApplication.class,args);
	}
}