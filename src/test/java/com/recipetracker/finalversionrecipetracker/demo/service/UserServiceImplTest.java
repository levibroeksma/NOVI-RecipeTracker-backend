package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Authority;
import com.recipetracker.finalversionrecipetracker.demo.model.User;
import com.recipetracker.finalversionrecipetracker.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    public void GetAllUsersTest() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));
        Collection<User> userList = userServiceImpl.getUsers();
        assertEquals(2, userList.size());
    }

    @Test
    public void deleteUserTest() {
        User user = new User();
        user.setUsername("levi");
        userServiceImpl.deleteUser(user.getUsername());
        verify(userRepository).deleteById(user.getUsername());
    }

    @Test
    public void GetUserTest() {
        User user = new User();
        user.setUsername("levi");
        String username = user.getUsername();
        when(userRepository.findById(username)).thenReturn(Optional.of(user));
        Optional<User> userOptional = userServiceImpl.getUser(username);
        assertTrue(userOptional.isPresent());
        assertEquals(username, userOptional.get().getUsername());
    }

    @Test
    public void UserExistsTest() {
        User user = new User();
        user.setUsername("levi");
        String username = user.getUsername();
        when(userRepository.existsById(username)).thenReturn(true);
        assertTrue(userRepository.existsById(username));
    }

    @Test
    public void UpdateUserTest() {
        User initialUser = new User();
        initialUser.setUsername("levi");
        initialUser.setPassword("password");
        User update = new User();
        update.setUsername("hans");
        update.setPassword("password");
        when(userRepository.existsById(update.getUsername())).thenReturn(true);
        when(userRepository.findById(update.getUsername())).thenReturn(Optional.of(initialUser));
        userServiceImpl.updateUser(update.getUsername(), update);
        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        assertThat(savedUser.getPassword().equals(update.getPassword()));
    }

    @Test
    public void CreateUserTest() {
        User initialUser = new User();
        initialUser.setUsername("levi");
        initialUser.setPassword(passwordEncoder.encode("password"));
        String passwordForm = passwordEncoder.encode(initialUser.getPassword());
        when(userRepository.save(initialUser)).thenReturn(initialUser);
        userServiceImpl.createUser(initialUser);
        verify(userRepository).save(userCaptor.capture());
        User newUser = userCaptor.getValue();
        assertThat(initialUser.getUsername().equals(newUser.getUsername()));
    }

    @Test
    public void GetAuthoritiesTest() {
        User testUser = new User();
        testUser.setUsername("username");
        testUser.addAuthority(new Authority(testUser.getUsername(), "ADMIN"));
        when(userRepository.existsById(testUser.getUsername())).thenReturn(true);
        when(userRepository.findById(testUser.getUsername())).thenReturn(java.util.Optional.of(testUser));
        assertEquals(testUser.getAuthorities(), userServiceImpl.getAuthorities(testUser.getUsername()));
    }

    @Test
    public void RemoveAuthorityTest() {
        User testUser = new User();
        testUser.setUsername("username");
        testUser.addAuthority(new Authority(testUser.getUsername(), "ADMIN"));
        when(userRepository.existsById(testUser.getUsername())).thenReturn(true);
        when(userRepository.findById(testUser.getUsername())).thenReturn(java.util.Optional.of(testUser));
        userServiceImpl.removeAuthority(testUser.getUsername(), "ADMIN");
        verify(userRepository).save(testUser);
    }


    @Test
    public void UpdateUserTest2(){
        User testUser = new User();
        testUser.setUsername("username");
        User testUser2 = new User();
        testUser2.setUsername("anotherUsername");
        when(userRepository.existsById(testUser.getUsername())).thenReturn(false);
        assertThrows(RecordNotFoundException.class, ()-> {
            userServiceImpl.updateUser(testUser.getUsername(), testUser2);
        });
    }
}
