package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public void addUser(User user) {
    Optional<User> findedUser = userRepository.findUserByName(user.getName());
    if (findedUser.isPresent()) {
      throw new IllegalStateException("name already in use");
    }

    userRepository.save(user);
  }

  public void deleteUser(Long userId) {
    boolean exists = userRepository.existsById(userId);
    if (!exists) {
      throw new IllegalStateException("user with id " + userId + " does not exists");
    }
    userRepository.deleteById(userId);
  }

  @Transactional
  public void updateName(Long userId, String name) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exists"));

    if (!Objects.equals(user.getName(), name)) {
      Optional<User> findedUser = userRepository.findUserByName(name);
      if (findedUser.isPresent()) {
        throw new IllegalStateException("name already in use");
      }
      user.setName(name);
    }
  }
}
