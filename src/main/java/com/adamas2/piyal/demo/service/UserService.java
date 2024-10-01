package com.adamas2.piyal.demo.service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.adamas2.piyal.demo.entity.User;
import com.adamas2.piyal.demo.repository.UserRepository;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
     // getting all users in sorted order based on their score
        return userRepository.findAll().stream()
                .sorted((u1,u2)->Integer.compare(u2.getScore(),u1.getScore()))
                .toList();
    }
    // getting one user if exists 
    public Optional<User> getUserById(String userId){
        return userRepository.findById(userId);
    }  

    public User registerUser(User user){
        user.setScore(0);  // seting score as 0
        user.setBadges(new HashSet<>()); // empty user badge
        return userRepository.save(user);
    }

    public User updateScore(String userId,int score){
        User user= userRepository.findById(userId).
        orElseThrow(()-> new RuntimeException("User not found"));
        if(score<0 || score >100) throw new IllegalArgumentException("Invalid Score");
        user.setScore(score);
        assignBadges(user);
        return userRepository.save(user);
    }

    private void assignBadges(User user) {
        int score = user.getScore();
        Set<String> badges = new HashSet<>();
        if (score >= 1 && score < 30) {
            badges.add("Code Ninja");
        } else if (score >= 30 && score < 60) {
            badges.add("Code Champ");
        } else if (score >= 60 && score <= 100) {
            badges.add("Code Master");
        }
        user.setBadges(badges);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
    
}
