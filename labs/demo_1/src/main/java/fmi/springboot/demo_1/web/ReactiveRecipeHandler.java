package fmi.springboot.demo_1.web;

import fmi.springboot.demo_1.domain.Recipe;
import fmi.springboot.demo_1.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class ReactiveRecipeHandler {
    @Autowired
    private RecipeService service;

    public Mono<ServerResponse> getAllRecipes(ServerRequest request){
        return ServerResponse.ok().body(service.getAll(), Recipe.class);
    }

    public Mono<ServerResponse> create(ServerRequest request){
        return request.bodyToMono(Recipe.class)
                .flatMap(service::create)
                .flatMap(createdRecipe ->
                        ServerResponse.created(request.uriBuilder().pathSegment("{id}")
                                .build(createdRecipe.getId())).syncBody(createdRecipe));
    }

    public Mono<ServerResponse> getOne(ServerRequest request){
        return ServerResponse.ok().body(service.get(request.pathVariable("id")), Recipe.class);
    }

    public Mono<ServerResponse> update(ServerRequest request){
        return request.bodyToMono(Recipe.class)
                .flatMap(service::update)
                .flatMap(updatedRecipe ->
                        ServerResponse.ok().syncBody(updatedRecipe));
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        service.delete(request.pathVariable("id"));
        return ServerResponse.ok().build();
    }
}
