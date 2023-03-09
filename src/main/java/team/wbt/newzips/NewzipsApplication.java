package team.wbt.newzips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class NewzipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewzipsApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider() {
		// TODO: Spring Security를 사용해 세션 정보를 가져와 ID 가져올 것
		return () -> Optional.of(UUID.randomUUID().toString());
	}

}