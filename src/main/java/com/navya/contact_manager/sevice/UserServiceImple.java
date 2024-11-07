package com.navya.contact_manager.sevice;

import com.navya.contact_manager.dao.UserRepository;
import com.navya.contact_manager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImple implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(int user_id) {
        return userRepository.findById(user_id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(int user_id, User updatedUser) {
        return userRepository.findById(user_id).map(
                user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    user.setContactGroups(updatedUser.getContactGroups());
                    return userRepository.save(user);
                }
        )
                .orElseThrow(() -> new RuntimeException("User not found with id "+ user_id));
    }

    @Override
    public void deleteUser(int user_id) {
        userRepository.deleteById(user_id);

    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
