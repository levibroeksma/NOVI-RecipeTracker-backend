package com.recipetracker.finalversionrecipetracker.demo.auth.repository;

import java.util.Optional;

import com.recipetracker.finalversionrecipetracker.demo.auth.models.ERole;
import com.recipetracker.finalversionrecipetracker.demo.auth.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}