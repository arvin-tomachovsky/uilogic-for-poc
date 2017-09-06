package ca.poc.uilogic;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		// Print out the loaded bean definitions
		List<String> beanNames = Arrays.asList(ctx.getBeanDefinitionNames());
//		beanNames.forEach((name) -> System.out.println(" - " + name));
	}
}