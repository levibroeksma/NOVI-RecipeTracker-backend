package com.recipetracker.finalversionrecipetracker.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "directions")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 1000)
    private String directionName;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return directionName;
    }
    public void setName(String name) {
        this.directionName = name;
    }
    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}