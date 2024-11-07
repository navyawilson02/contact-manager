package com.navya.contact_manager.sevice;

import com.navya.contact_manager.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserById(int user_id);
    List<User> getAllUsers();
    User updateUser(int user_id, User updatedUser);
    void deleteUser(int user_id);
    Optional<User> getUserByUsername(String username);
}
