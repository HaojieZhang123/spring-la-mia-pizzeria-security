package org.exercise.java.spring_la_mia_pizzeria_security.security;

import java.util.Optional;

import org.exercise.java.spring_la_mia_pizzeria_security.model.User;
import org.exercise.java.spring_la_mia_pizzeria_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return new DatabaseUserDetails(userOptional.get());
        }
    }

}
