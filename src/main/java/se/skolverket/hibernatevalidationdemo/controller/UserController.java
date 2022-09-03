package se.skolverket.hibernatevalidationdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.skolverket.hibernatevalidationdemo.exception.CustomisedException;
import se.skolverket.hibernatevalidationdemo.model.User;
import se.skolverket.hibernatevalidationdemo.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/customised")
    public ResponseEntity<Map<String, String>> createUser(@RequestParam("cause") String cause) {
        throw  new CustomisedException("cause is " + cause);
    }
}
