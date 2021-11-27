package labdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "labdb")
public class LabdbApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(LabdbApplication.class, args);
	}

}
