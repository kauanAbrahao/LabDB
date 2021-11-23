package labdb.labdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class LabdbApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(LabdbApplication.class, args);
	}

}
