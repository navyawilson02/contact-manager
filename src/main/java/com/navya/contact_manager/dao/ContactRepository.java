package com.navya.contact_manager.dao;

import com.navya.contact_manager.entities.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contacts, Integer> {
    //find all contacts by a specific user's id
    List<Contacts> findUserById(int user_id);

    List<Contacts> findByFirstname(String firstname); //finds contacts by first name
}
