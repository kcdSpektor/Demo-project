package com.alex.z.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Demo project by Alex Z", version = "1.0"),
		servers = {@Server(url = "http://localhost:8080")}
)
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
		openBrowser();
	}

	private static void openBrowser() throws IOException {
		String url = "http://localhost:8080/swagger-ui/index.html";
		Runtime rt = Runtime.getRuntime();
		rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
	}

}
