package se.skolverket.hibernatevalidationdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.skolverket.hibernatevalidationdemo.model.User;
import se.skolverket.hibernatevalidationdemo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
       return userRepository.save(user);
    }

    public User findUseById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAllWithSort(Sort sort) {
        return (List<User>) userRepository.findAll(sort);
    }

    public List<User> findByJobContainingWithSort(String job, Sort sort) {
        return userRepository.findByJobContaining(job, sort);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
