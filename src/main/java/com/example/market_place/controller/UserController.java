package com.example.market_place.controller;

import com.example.market_place.dto.ProductDto;
import com.example.market_place.dto.UserDto;
import com.example.market_place.entity.User;
import com.example.market_place.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
