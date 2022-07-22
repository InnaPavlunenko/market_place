package com.example.market_place.service;

import com.example.market_place.dto.ProductDto;
import com.example.market_place.dto.UserDto;
import com.example.market_place.entity.Product;
import com.example.market_place.entity.User;
import com.example.market_place.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(User user) {

        user.setId(ObjectId.get());
        userRepository.save(user);
        UserDto userResponse = new UserDto();
        userResponse.setId(user.getId().toString());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setAmountOfMoney(user.getAmountOfMoney());

        return userResponse;
    }

    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> users = new ArrayList<>();
        for(User user: userList) {
            UserDto userResponse = new UserDto();
            userResponse.setId(user.getId().toString());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setAmountOfMoney(user.getAmountOfMoney());
            users.add(userResponse);
        }
        return users;
    }


}
