package fmi.springboot.demo_1.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("recipes")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private int timeToCook;
    @NonNull
    private String description;
    @NonNull
    private List<String> ingredients;

    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;
}
