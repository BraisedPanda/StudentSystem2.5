package com.braisedpanda.shirotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication

@MapperScan("mybatis.mapper")
public class ShirotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirotestApplication.class, args);
	}

}
