package com.tccmicronaut.delivery;

import com.tccmicronaut.model.User;
import com.tccmicronaut.service.FollowsService;
import com.tccmicronaut.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

@Controller(value = "/users")
public class UserController {

    private static UserService userService;
    
    private static FollowsService followsService;

    public UserController(UserService userService, FollowsService followsService) {
        UserController.userService = userService;
        UserController.followsService = followsService;
    }


    @Post(value = "/create")
    public static HttpResponse create(@Body User user) {
        try {
            userService.create(user);
            return HttpResponse.ok();
        } catch (Exception e) {
        	e.printStackTrace();
            return HttpResponse.badRequest();
        }
    }

    @Get(value = "/{id}")
    public static HttpResponse<User> get(@PathVariable Long id) {
        try {
            return HttpResponse.ok(userService.findById(id));
        } catch (Exception e) {
        	e.printStackTrace();
            return HttpResponse.badRequest();
        }
    }

    @Put(value = "/update")
    public static HttpResponse update(@Body User user) {
        try {
            userService.update(user);
            return HttpResponse.ok();
        } catch (Exception e) {
        	e.printStackTrace();
            return HttpResponse.badRequest();
        }
    }

    @Delete(value = "/delete/{id}")
    public static HttpResponse delete(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return HttpResponse.ok();
        } catch (Exception e) {
        	e.printStackTrace();
            return HttpResponse.badRequest();
        }
    }

    @Get(value = "/all")
    public static HttpResponse<Iterable<User>> getAll() {
        try {
            return HttpResponse.ok(userService.findAll());
        } catch (Exception e) {
        	e.printStackTrace();
            return HttpResponse.badRequest();
        }
    }

    @Put(value = "/{id}/follow/{idToFollow}")
    public static HttpResponse follow(@PathVariable Long id, @PathVariable Long idToFollow) {
        try {
        	followsService.follow(id, idToFollow);
            return HttpResponse.ok();
        } catch (Exception e) {
        	e.printStackTrace();
            return HttpResponse.badRequest();
        }
    }

    @Get(value = "/follow/find/{id}")
    public static HttpResponse findFollowers(@PathVariable Long id) {
        try {
        	followsService.findFollowers(id);
            return HttpResponse.ok();
        } catch (Exception e) {
        	e.printStackTrace();
            return HttpResponse.badRequest();
        }
    }

}
