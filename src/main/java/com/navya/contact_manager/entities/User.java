package com.navya.contact_manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @JsonIgnore //prevent password from being included in json response
    @Column(nullable = false)
    private String password; //need to implement hashing

    @ManyToMany
    @JoinTable(
            name="user_contact_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="group_id")
    )
    private List<ContactGroup> contactGroups;

//    @Column(updatable = false)
//    private LocalDateTime createdAt;

//    private LocalDateTime updatedAt;
    public User(){} //default constructor for jpa


    public User(int user_id, String username, String name, String email, String password, List<ContactGroup> contactGroups) {
        this.user_id = user_id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactGroups = contactGroups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ContactGroup> getContactGroups() {
        return contactGroups;
    }

    public void setContactGroups(List<ContactGroup> contactGroups) {
        this.contactGroups = contactGroups;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactGroups=" + contactGroups +
                '}';
    }
}
