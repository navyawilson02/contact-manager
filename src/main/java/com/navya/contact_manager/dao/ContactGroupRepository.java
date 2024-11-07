package com.navya.contact_manager.dao;

import com.navya.contact_manager.entities.ContactGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactGroupRepository extends JpaRepository<ContactGroup,Integer> {
    //find a contact group by its name
    Optional<ContactGroup> findByGroupName(String group_name);
}
