package com.navya.contact_manager.sevice;

import com.navya.contact_manager.dao.ContactRepository;
import com.navya.contact_manager.entities.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    //get all contacts
    public List<Contacts> getAllContacts(){
        return contactRepository.findAll();
    }

    //get a contact by id
    public Optional<Contacts> getContactById(int contact_id){
        return contactRepository.findById(contact_id);
    }

    //create a new contact
    public Contacts createContact(Contacts contacts){
        return contactRepository.save(contacts);
    }

    //update an existing contact
    public Contacts updateContact(int contact_id, Contacts contactDetails){
        Optional<Contacts> existingContact= contactRepository.findById(contact_id);
        if(existingContact.isPresent()){
            Contacts contacts=existingContact.get();
            contacts.setFirstname(contactDetails.getFirstname());
            contacts.setLastname(contactDetails.getLastname());
            contacts.setPhone_number(contactDetails.getPhone_number());
            contacts.setEmail(contactDetails.getEmail());
            return contactRepository.save(contacts);
        }
        else {
            throw new RuntimeException("Contact not found with Id: "+contact_id);
        }
        // delete a contact by id
//        public void deleteContact(int contact_id){
//            contactRepository.deleteById(contact_id);
//        }

//        public List<Contacts> getContactByUserId(int user_id){
//            return contactRepository.findUserById(user_id);
//        }
    }
}
