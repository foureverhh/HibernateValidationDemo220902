package se.skolverket.hibernatevalidationdemo.controller;


import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.skolverket.hibernatevalidationdemo.exception.CustomisedException;
import se.skolverket.hibernatevalidationdemo.model.User;
import se.skolverket.hibernatevalidationdemo.service.UserService;

import javax.validation.Valid;
import java.util.*;

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
    public ResponseEntity<Map<String, String>> customisedException(@RequestParam("cause") String cause) {
        throw new CustomisedException("cause is " + cause);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<String> return404(@PathVariable("id") Long id) {
            User user = userService.findUseById(id);
            return user == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>("The id is " + id, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        User user = userService.findUseById(id);
        return user == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/sort/users/all")
    public ResponseEntity<?> getAllUsersWithSort() {
        //sort by name ascending and by job descending
        List<User> users = userService.findAllWithSort(Sort.by("name").ascending().and(Sort.by("job").descending()));
        return users == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/pagedListHolder/users/all")
    public ResponseEntity<?> getAllUsersWithPagedListHolder(@RequestParam("page")String page, @RequestParam("size")String size, @RequestParam("sort")String sort, @RequestParam("order")String order) {
        //sort by name ascending and by job descending
        List<User> users = userService.findAll();
        Collections.sort(users);
        PagedListHolder<User> pagedListHolder = new PagedListHolder<>(users);
        if (order.equals("1"))
            pagedListHolder.setSort(new MutableSortDefinition(sort, false,true));
        else
            pagedListHolder.setSort(new MutableSortDefinition(sort, false,false));
        pagedListHolder.resort();
        pagedListHolder.setPage(Integer.parseInt(page));
        pagedListHolder.setPageSize(Integer.parseInt(size));
        return new ResponseEntity<>(pagedListHolder, HttpStatus.OK);
    }

    // return default error message, not suitable for Restful api
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Pass number only")
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, String> testResponseStatus(IllegalArgumentException e) {
        Map<String, String> error = new HashMap<>();
        error.put("param illegal", e.getMessage());
        System.out.println("test Response status is called");
        return error;
    }
}
