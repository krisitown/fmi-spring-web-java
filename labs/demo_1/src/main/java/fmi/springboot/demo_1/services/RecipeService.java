package fmi.springboot.demo_1.services;

import fmi.springboot.demo_1.domain.Recipe;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecipeService {
    Mono<Recipe> create(Recipe recipe);
    Mono<Recipe> get(String recipeId);
    Flux<Recipe> getAll();
    Mono<Recipe> update(Recipe recipe);
    Mono<Void> delete(String recipeId);
}
