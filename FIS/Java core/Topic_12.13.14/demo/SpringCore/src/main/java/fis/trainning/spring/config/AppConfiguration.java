package fis.trainning.spring.config;

import fis.trainning.spring.lang.Language;
import fis.trainning.spring.lang.Vietnamese;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"fis.trainning.spring.bean"})
public class AppConfiguration {
    @Bean(name ="language")
    public Language getLanguage() {

        return new Vietnamese();
    }
}
