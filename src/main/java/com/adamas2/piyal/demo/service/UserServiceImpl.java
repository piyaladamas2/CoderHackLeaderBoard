package com.adamas2.piyal.demo.service;

import java.util.Set;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator; 
import java.util.Collections;
import com.adamas2.piyal.demo.dto.UserDTO;
import com.adamas2.piyal.demo.entity.User;
import com.adamas2.piyal.demo.exchange.UserRequest;
import com.adamas2.piyal.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired 
    UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserRequest userRequest) {
        
        User user= User.builder()
        .userId(userRequest.getUserId())
        .userName(userRequest.getUserName())
        .score(0)
        .badges(null)
        .build();
        user= userRepository.save(user);

        return mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u2.getScore(), u1.getScore()); // For descending order
            }
        });
        return users.stream()
        .map(this::mapToUserDTO)
        .toList();
    }

    @Override
    public UserDTO getUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(this::mapToUserDTO).orElse(null);
    }

    @Override
    public void deleteUserById(String userId) {
        
        userRepository.deleteById(userId);
    }

    private UserDTO mapToUserDTO(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .score(user.getScore())
                .badges(user.getBadges())
                .build();
    }

    @Override
    public UserDTO updateScore(String userId, int score) {
        Optional<User> optionalUser = userRepository.findById(userId);
    
        // Check if user exists
        if (optionalUser.isPresent()) {
            User user = optionalUser.get(); // Retrieve the user
            
            // Update the user's score
            user.setScore(score);
            
            // Award badges based on the score
            awardBadges(user);
            
            // Save the updated user back to the repository
            userRepository.save(user);
            
            // Return the updated UserDTO
            return mapToUserDTO(user);
        }
        
        // Return null or throw an exception if user is not found
        return null; // Or you could throw an exception based on your application logic
    }


    private void awardBadges(User user) {

        Set<String> badges = user.getBadges(); // Get existing badges
    
        // Determine new badge(s) based on the score
        if (user.getScore() >= 1 && user.getScore() < 30) {
            addBadgeIfValid(badges, "Code Ninja");
        } else if (user.getScore() >= 30 && user.getScore() < 60) {
            addBadgeIfValid(badges, "Code Champ");
        } else if (user.getScore() >= 60 && user.getScore() <= 100) {
            addBadgeIfValid(badges, "Code Master");
        }
        
        // Update the user's badges
        user.setBadges(badges);
    }
    
    private void addBadgeIfValid(Set<String> badges, String badge) {
        // Add badge if it is not already in the set and does not exceed the maximum of 3 unique badges
        if (!badges.contains(badge)) {
            if (badges.size() < 3) {
                badges.add(badge); // Add the new badge
            } else {
                // Optionally handle the case where the user already has 3 badges
                // For example, you might want to log this or notify the user
                System.out.println("Cannot add badge: " + badge + ". Maximum number of unique badges reached.");
            }
        }

    }
}    
