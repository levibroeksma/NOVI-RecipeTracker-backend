package com.recipetracker.finalversionrecipetracker.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "cookingtime")
    private String cookingtime;

    @Column(name = "calories")
    private String calories;

    @Column(name = "username")
    private String username;

    @Column(name = "userCountry")
    private String userCountry;

    // Booleans

    @Column(name = "beef")
    private boolean beef;

    @Column(name = "fish")
    private boolean fish;

    @Column(name = "pork")
    private boolean pork;

    @Column(name = "poultry")
    private boolean poultry;

    @Column(name = "lamb")
    private boolean lamb;

    @Column(name = "vegan")
    private boolean vegan;

    @Column(name = "vegetarian")
    private boolean vegetarian;

    @Column(name = "spicy")
    private boolean spicy;

    //Extending arrays

    @OneToMany(
            targetEntity = Ingredient.class,
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

//    @OneToMany(
//            targetEntity = Direction.class,
//            mappedBy = "recipe",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER)
//    private List<Direction> directions;
}