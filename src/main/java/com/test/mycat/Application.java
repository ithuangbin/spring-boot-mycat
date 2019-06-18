package com.test.mycat;

import com.test.mycat.config.db.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.test.mycat.dao")
@EnableAutoConfiguration
@Import(DynamicDataSourceRegister.class)
public class Application {
	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
		LOGGER.info("项目启动 ");
	}
}