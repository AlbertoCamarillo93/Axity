package mx.com.axity.userservice.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value= {"mx.com.axity.userservice"})
@EnableJpaRepositories("mx.com.axity.userservice.persistence")
@EntityScan("mx.com.axity.userservice.model")
public class UserserviceApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = SpringApplication.run(UserserviceApplication.class, args);
		
		for (String name: applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
	}

}
