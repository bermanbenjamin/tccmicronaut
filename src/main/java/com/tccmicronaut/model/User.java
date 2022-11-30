package com.tccmicronaut.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;


@MappedEntity
public class User {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    private Long followers;

    private Date birthdate;
    
    public User() {}

    public User(Long id, String name, String password, ArrayList<String> posts, Long followers,
                Date birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.followers = followers;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }




}
