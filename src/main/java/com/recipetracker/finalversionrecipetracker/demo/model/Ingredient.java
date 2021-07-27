package com.recipetracker.finalversionrecipetracker.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ingredientName;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false, referencedColumnName="id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Recipe recipe;

//    @Column(name = "recipe_id")
//    private Integer recipeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return ingredientName;
    }

    public void setName(String name) {
        this.ingredientName = name;
    }

}