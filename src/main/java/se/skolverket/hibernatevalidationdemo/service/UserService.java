package se.skolverket.hibernatevalidationdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.skolverket.hibernatevalidationdemo.model.User;
import se.skolverket.hibernatevalidationdemo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
       return userRepository.save(user);
    }
}
