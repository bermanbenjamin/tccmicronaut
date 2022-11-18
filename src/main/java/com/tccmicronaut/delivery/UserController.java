package com.tccmicronaut.delivery;

import com.tccmicronaut.model.User;
import com.tccmicronaut.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

@Controller(value = "/users")
public class UserController {

    private static UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Post(value = "/create")
    public static HttpResponse create(@Body User user) {
        try {
            userService.create(user);
            return HttpResponse.ok();
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Get(value = "/{id}")
    public static HttpResponse<User> get(@PathVariable String id) {
        try {
            return HttpResponse.ok(userService.findById(id));
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Put(value = "/update")
    public static HttpResponse update(@Body User user) {
        try {
            userService.update(user);
            return HttpResponse.ok();
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Delete(value = "/delete/{id}")
    public static HttpResponse delete(@PathVariable String id) {
        try {
            userService.deleteById(id);
            return HttpResponse.ok();
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Get(value = "/all")
    public static HttpResponse<Iterable<User>> getAll() {
        try {
            return HttpResponse.ok(userService.findAll());
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Put(value = "/{id}/follow/{idToFollow}")
    public static HttpResponse follow(@PathVariable String id, @PathVariable String idToFollow) {
        try {
            userService.follow(id, idToFollow);
            return HttpResponse.ok();
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }


}
