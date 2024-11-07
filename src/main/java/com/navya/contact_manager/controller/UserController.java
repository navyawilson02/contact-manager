package com.navya.contact_manager.controller;

import com.navya.contact_manager.entities.User;
import com.navya.contact_manager.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    //post requests to create new user
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    //get request to fetch a user by id
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    @GetMapping
    //get request to retrieve all users
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    //put request to update user's information
    public User updateUser(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    //to delete a user by id
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }


}
