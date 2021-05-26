package com.aubay.user.service;

import com.aubay.user.entity.User;
import com.aubay.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveAndFlush(User s) {
        return userRepository.saveAndFlush(s);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.delete(getById(id));
    }

    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
