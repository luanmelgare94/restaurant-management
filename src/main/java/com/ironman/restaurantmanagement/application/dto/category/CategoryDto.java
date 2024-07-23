package com.ironman.restaurantmanagement.application.dto.category;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private String urlKey;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}