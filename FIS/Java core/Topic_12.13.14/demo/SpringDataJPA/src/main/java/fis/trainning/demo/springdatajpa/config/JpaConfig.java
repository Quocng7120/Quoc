package fis.trainning.demo.springdatajpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "fis.trainning.demo.springdatajpa.repository")
public class JpaConfig {
}
