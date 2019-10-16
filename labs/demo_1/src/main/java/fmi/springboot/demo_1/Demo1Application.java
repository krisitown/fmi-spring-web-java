package fmi.springboot.demo_1;

import fmi.springboot.demo_1.web.ReactiveRecipeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class Demo1Application {
	@Autowired
	private ReactiveRecipeHandler handler;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> router() {
		return route(GET("/api/recipes"), handler::getAllRecipes)
				.andRoute(POST("/api/recipes"), handler::create)
				.andRoute(GET("/api/recipes/{id}"), handler::getOne)
				.andRoute(PUT("/api/recipes"), handler::update)
				.andRoute(DELETE("/api/recipes/{id}"), handler::delete);
	}
}
