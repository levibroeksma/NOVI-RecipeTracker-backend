package com.recipetracker.finalversionrecipetracker.demo.model;

import org.hibernate.annotations.Cascade;

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

    @OneToMany(mappedBy = "recipe")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<Ingredients> ingredients;

    @Lob
    byte[] recipeImage;

    public Recipe(String title, String description, boolean b) {
        this.title = title;
        this.description = description;
        this.beef = beef;
        this.fish = fish;
        this.lamb = lamb;
        this.pork = pork;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
        this.spicy = spicy;
        this.recipeImage = recipeImage;
        this.country = country;
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

    public boolean isBeef() {
        return beef;
    }

    public boolean isFish() {
        return fish;
    }

    public boolean isLamb() {
        return lamb;
    }

    public boolean isPork() {
        return pork;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public String getCountry() {
        return country;
    }

    //Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBeef(boolean beef) {
        this.beef = beef;
    }

    public void setFish(boolean fish) {
        this.fish = fish;
    }

    public void setLamb(boolean lamb) {
        this.lamb = lamb;
    }

    public void setPork(boolean pork) {
        this.pork = pork;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Recipe [id=" + id + ", title=" + title + ", desc=" + description + ", beef=" + beef + ", fish=" + fish + ", lamb=" + lamb + ", pork=" + pork + ", vegan=" + vegan + ", vegetarian=" + vegetarian + ", spicy=" + spicy +  ", country=" + country + "]";
    }
}