package com.aubay.user.service;

import com.aubay.user.entity.User;
import com.aubay.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

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
}
