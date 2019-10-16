package fmi.springboot.demo_1.repositories;

import fmi.springboot.demo_1.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveRecipeRepository extends ReactiveMongoRepository<Recipe, String> {
}
