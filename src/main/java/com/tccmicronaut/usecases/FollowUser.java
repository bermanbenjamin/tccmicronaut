package com.tccmicronaut.usecases;

import com.tccmicronaut.model.User;
import com.tccmicronaut.service.UserService;

public class FollowUser {

    private static UserService userService;

    public FollowUser(UserService userService) {
        this.userService = userService;
    }

    public void follow(User userFollowed, User userFollower) {
        userFollowed.getFollowers().add(userFollower.getId());
        userService.update(userFollowed);
    }

}