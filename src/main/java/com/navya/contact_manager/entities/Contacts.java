package com.navya.contact_manager.entities;

import jakarta.persistence.*;

//import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contact_id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false,unique = true)
    private String phone_number;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
    @ManyToMany
    @JoinTable(
            name = "contact_to_contact_group",
            joinColumns = @JoinColumn(name="contact_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<ContactGroup> contactGroups;

    public Contacts(){} //default construct for jpa

    public Contacts(int contact_id, String firstname, String lastname, String phone_number, String email, User user, List<ContactGroup> contactGroups) {
        this.contact_id = contact_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_number = phone_number;
        this.email = email;
        this.user = user;
        this.contactGroups = contactGroups;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contact_id=" + contact_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }
}
