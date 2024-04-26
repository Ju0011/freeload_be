package ju00.freeload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FreeloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeloadApplication.class, args);
	}

}
