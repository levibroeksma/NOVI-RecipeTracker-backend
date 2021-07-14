package com.recipetracker.finalversionrecipetracker.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String apikey;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private boolean newsLetter = false;

    @Column
    private String country;

    @OneToMany(
            targetEntity = com.recipetracker.finalversionrecipetracker.demo.model.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<com.recipetracker.finalversionrecipetracker.demo.model.Authority> authorities = new HashSet<>();

    // username
    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }
    // password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // enabled
    public boolean isEnabled() { return enabled;}
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    // apikey
    public String getApikey() { return apikey; }
    public void setApikey(String apikey) { this.apikey = apikey; }
    //email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}
    //first name
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //last name
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //newletter
    public boolean isNewsLetter() {
        return newsLetter;
    }
    public void setNewsLetter(boolean newsLetter) {
        this.newsLetter = newsLetter;
    }
    //country
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

}