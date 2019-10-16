package fmi.springboot.demo_1.services;

import fmi.springboot.demo_1.domain.Recipe;
import fmi.springboot.demo_1.repositories.ReactiveRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private ReactiveRecipeRepository repository;

    @Override
    public Mono<Recipe> create(Recipe recipe) {
        return repository.insert(recipe);
    }

    @Override
    public Mono<Recipe> get(String recipeId) {
        return repository.findById(recipeId);
    }

    @Override
    public Flux<Recipe> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Recipe> update(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public Mono<Void> delete(String recipeId) {
        return repository.deleteById(recipeId);
    }
}
