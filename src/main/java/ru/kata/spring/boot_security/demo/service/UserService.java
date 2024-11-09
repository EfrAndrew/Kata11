package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();

    User findUserById(Long id);

    User findUserByName (String username);

    void deleteUser(Long id);

    void saveUser(String name, String email, String password);

    void saveUser(String name, String email, String password, Set<Role> roles);

    void updateUser(Long id, String name, String email, String password);

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    @Transactional(readOnly = true)
    List<Role> getAllRoles();
}