package com.example.market_place.service;

import com.example.market_place.entity.User;
import com.example.market_place.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        user.setId(3424);
        userRepository.save(user);
        return user;
    }

}
