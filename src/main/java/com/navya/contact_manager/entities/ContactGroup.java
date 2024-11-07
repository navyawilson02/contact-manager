package com.navya.contact_manager.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "contact_group")
public class ContactGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int group_id;

    @Column(nullable = false)
    private String group_name;

    public ContactGroup(){} //default constructor for jpa

    public ContactGroup(int group_id, String group_name) {
        this.group_id = group_id;
        this.group_name = group_name;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
