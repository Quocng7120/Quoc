package fis.trainning.spring.departmentspringjdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"fis.trainning.spring.departmentspringjdbc.repository","fis.trainning.spring.departmentspringjdbc.config"})
public class AppConfiguration {
}
