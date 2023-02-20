package com.example.pp332.service;

import com.example.pp332.model.User;
import com.example.pp332.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImp  {

   private final UserRepository userRepository;
   @Autowired
   public UserServiceImp(UserRepository userRepository) {
      this.userRepository = userRepository;
   }


   @Transactional
   public void save(User user) {
      userRepository.save(user);
   }


   public List<User> showUsers() {

      return userRepository.findAll();
   }


   public User getUser(Long id) {
     return userRepository.getOne(id);
   }


   @Transactional
   public void delete(Long id) {
      userRepository.deleteById(id);
   }


   @Transactional
   public void update(User user) {
      userRepository.save(user);
   }
}
