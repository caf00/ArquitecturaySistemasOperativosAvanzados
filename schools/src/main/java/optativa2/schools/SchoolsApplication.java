package optativa2.schools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SchoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolsApplication.class, args);
	}

}
