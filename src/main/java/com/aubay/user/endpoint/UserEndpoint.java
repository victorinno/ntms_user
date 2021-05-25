package com.aubay.user.endpoint;

import com.aubay.user.entity.User;
import com.aubay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserEndpoint {

    @Autowired
    private UserService userService;

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

    @DeleteMapping("/user/id")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
