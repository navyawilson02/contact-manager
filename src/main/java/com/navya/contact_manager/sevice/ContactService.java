package com.navya.contact_manager.sevice;

import com.navya.contact_manager.entities.Contacts;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contacts createContact(Contacts contacts);
    Optional<Contacts> getContactById(int contact_id);
    List<Contacts> getAllContacts();
    List<Contacts> getContactByUserId(int user_id);
    Contacts updateContact(int contact_id, Contacts updatedContact);
    void deleteContact(int contact_id);
}
