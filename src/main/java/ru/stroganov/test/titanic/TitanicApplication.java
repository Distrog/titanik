package ru.stroganov.test.titanic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.stroganov.test.titanic.download_csv.CsvDownloader;

@SpringBootApplication
@EnableCaching
public class TitanicApplication {

	public static void main(String[] args) {
		SpringApplication.run(TitanicApplication.class, args);
	}

}
