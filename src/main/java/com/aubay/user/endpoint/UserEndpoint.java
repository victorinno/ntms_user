package com.aubay.user.endpoint;

import com.aubay.user.api.Result;
import com.aubay.user.entity.User;
import com.aubay.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/user")
    public User save(@RequestBody User s) {
        return userService.saveAndFlush(s);
    }

    @PostMapping("/user")
    public User update(@RequestBody User s) {
        return userService.saveAndFlush(s);
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("/user/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("/user/{name}")
    public User findUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/user/{name}/validate")
    public Result validateUser(@PathVariable String name) {
        return new Result(Optional.ofNullable(userService.findUserByName(name)).isPresent());
    }
}
