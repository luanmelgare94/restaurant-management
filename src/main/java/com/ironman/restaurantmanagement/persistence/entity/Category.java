package com.ironman.restaurantmanagement.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// JPA annotations
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(name = "url_key")
    private String urlKey;
    private String state;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}