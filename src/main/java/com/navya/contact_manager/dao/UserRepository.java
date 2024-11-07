package com.navya.contact_manager.dao;

import com.navya.contact_manager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

}
