package com.adamas2.piyal.demo.service;

import com.adamas2.piyal.demo.dto.UserDTO;
import com.adamas2.piyal.demo.exchange.UserRequest;
import java.util.List;

public interface UserService {
    UserDTO registerUser(UserRequest userRequest);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String userId);
    void deleteUserById(String userId);
    UserDTO updateScore(String userId,int score);
}
