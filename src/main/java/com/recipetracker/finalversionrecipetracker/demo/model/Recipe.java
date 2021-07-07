package com.recipetracker.finalversionrecipetracker.demo.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "beef")
    private boolean beef;

    @Column
    private String picturePath;

    @Column(name = "fish")
    private boolean fish;

    @Column(name = "lamb")
    private boolean lamb;

    @Column(name = "pork")
    private boolean pork;

    @Column(name = "vegan")
    private boolean vegan;

    @Column(name = "vegetarian")
    private boolean vegetarian;

    @Column(name = "spicy")
    private boolean spicy;

    @Column(name = "country")
    private String country;

//    @OneToMany(mappedBy = "recipe")
//    @Cascade(CascadeType.ALL)
//    List<Ingredients> ingredients;
//
//    @OneToMany(mappedBy = "recipe")
//    @Cascade(CascadeType.ALL)
//    List<Directions> directions;
//
//    @OneToMany(mappedBy = "recipe")
//    @Cascade(CascadeType.ALL)
//    List<Comments> comments;

    public Recipe(){

    }

    public Recipe(String title, String description, boolean isBeef, boolean isFish) {
        this.title = title;
        this.description = description;
        this.beef = isBeef;
        this.picturePath = picturePath;
        this.fish = isFish;
        this.lamb = lamb;
        this.pork = pork;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.spicy = spicy;
        this.country = country;
//        this.directions = directions;
//        this.ingredients = ingredients;
//        this.comments = comments;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //    public List<Ingredients> getIngredients() {
//        return ingredients;
//    }
//
//    public List<Directions> getDirections() {
//        return directions;
//    }
//
//    public List<Comments> getComments() {
//        return comments;
//    }

    //Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBeef() {
        return beef;
    }

    public void setBeef(boolean beef) {
        this.beef = beef;
    }

    public boolean isFish() {
        return fish;
    }

    public void setFish(boolean fish) {
        this.fish = fish;
    }

    public boolean isLamb() {
        return lamb;
    }

    public void setLamb(boolean lamb) {
        this.lamb = lamb;
    }

    public boolean isPork() {
        return pork;
    }

    public void setPork(boolean pork) {
        this.pork = pork;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }



    //    public void setRecipeImage(byte[] recipeImage) {
//        this.recipeImage = recipeImage;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

//    public void setIngredients(List<Ingredients> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public void setDirections(List<Directions> directions) {
//        this.directions = directions;
//    }
//
//    public void setComments(List<Comments> comments) {
//        this.comments = comments;
//    }

    @Override
    public String toString() {
//        return "Recipe [id=" + id + ", title=" + title + ", desc=" + description + ", beef=" + beef + ", fish=" + fish + ", lamb=" + lamb + ", pork=" + pork + ", vegan=" + vegan + ", vegetarian=" + vegetarian + ", spicy=" + spicy +  ", country=" + country +  ", ingredients=" + ingredients +  ", directions=" + directions +   ", comments=" + comments + "]";
        return "Recipe [id=" + id + ", title=" + title + ", desc=" + description + ", beef=" + beef + "]";
    }
}