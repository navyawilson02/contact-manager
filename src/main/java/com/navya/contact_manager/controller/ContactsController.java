package com.navya.contact_manager.controller;

import com.navya.contact_manager.entities.Contacts;
import com.navya.contact_manager.sevice.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {
   @Autowired
    private ContactService contactService;

    @PostMapping
   public Contacts createContact(@RequestBody Contacts contacts){
       return contactService.createContact(contacts);
   }

   @GetMapping("/{id}")
   public Contacts getContactById(@PathVariable int id){
        return contactService.getContactById(id).orElseThrow(()-> new RuntimeException("Contact not found"));
   }

   @GetMapping
   public List<Contacts> getAllContacts(){
        return contactService.getAllContacts();
   }

   @GetMapping("/user/{user_id}")
   public List<Contacts> getContactByUserId(@PathVariable int user_id){
        return contactService.getContactByUserId(user_id);
   }

    @PutMapping("/{id}")
    public Contacts updateContact(@PathVariable int id, @RequestBody Contacts updatedContact){
        return contactService.updateContact(id, updatedContact);
    }

    public void deleteContact(@PathVariable int id){
        contactService.deleteContact(id);
    }


}
