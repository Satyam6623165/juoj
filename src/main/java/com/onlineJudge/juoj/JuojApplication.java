package com.onlineJudge.juoj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.onlineJudge.codeforces"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class JuojApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuojApplication.class, args);
		System.out.println("App Started!!");
	}
}