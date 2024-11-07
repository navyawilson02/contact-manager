package com.navya.contact_manager.sevice;

import com.navya.contact_manager.dao.ContactRepository;
import com.navya.contact_manager.entities.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsServiceImpl  implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contacts createContact(Contacts contacts) {
        return contactRepository.save(contacts);
    }

    @Override
    public Optional<Contacts> getContactById(int contact_id) {
        return contactRepository.findById(contact_id);
    }

    @Override
    public List<Contacts> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contacts> getContactByUserId(int user_id) {
        return contactRepository.findUserById(user_id);
    }

    @Override
    public Contacts updateContact(int contact_id, Contacts updatedContact) {
        return contactRepository.findById(contact_id).map(contacts -> {
            contacts.setFirstname(updatedContact.getFirstname());
            contacts.setLastname(updatedContact.getLastname());
            contacts.setPhone_number(updatedContact.getPhone_number());
            contacts.setEmail(updatedContact.getEmail());
            contacts.setUser(updatedContact.getUser());
           contacts.setContactGroups(updatedContact.getContactGroups());
            return contactRepository.save(contacts);
        })
                .orElseThrow(()-> new RuntimeException("Contact not found with id " + contact_id));
    }

    @Override
    public void deleteContact(int contact_id) {
        contactRepository.deleteById(contact_id);

    }
}
