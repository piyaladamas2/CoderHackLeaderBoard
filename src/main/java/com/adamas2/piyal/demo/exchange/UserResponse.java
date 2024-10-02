package com.adamas2.piyal.demo.exchange;

import java.util.List;
import com.adamas2.piyal.demo.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse{
    List<UserDTO> listOfUser;
}
