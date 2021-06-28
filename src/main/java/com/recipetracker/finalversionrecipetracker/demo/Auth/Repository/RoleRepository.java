package com.recipetracker.finalversionrecipetracker.demo.Auth.Repository;

import java.util.Optional;

import com.recipetracker.finalversionrecipetracker.demo.Auth.models.ERole;
import com.recipetracker.finalversionrecipetracker.demo.Auth.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}