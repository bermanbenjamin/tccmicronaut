package com.tccmicronaut.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.jdbc.annotation.ColumnTransformer;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;


@MappedEntity
public class User {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    private ArrayList<String> posts;

    private ArrayList<String> followers;

    private Date birthdate;

    public User(String id, String name, String password, ArrayList<String> posts, ArrayList<String> followers,
                Date birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.posts = posts;
        this.followers = followers;
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ArrayList<String> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<String> posts) {
        this.posts = posts;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }




}
