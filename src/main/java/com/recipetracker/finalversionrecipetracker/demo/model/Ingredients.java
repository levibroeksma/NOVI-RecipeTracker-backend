package com.recipetracker.finalversionrecipetracker.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "/ingredients")
public class Ingredients {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Recipe recipe;
}