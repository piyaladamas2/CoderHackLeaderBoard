package com.adamas2.piyal.demo.entity;


import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @NotNull
    private String userId;
    @NotNull
    private String userName;
    
    private int score;
    private Set <String> badges;

}
//     public User() {
//        this.score = 0;
//        this.badges = new HashSet<>();
//    }

//    public User(String userId, String username) {
//        this.userId = userId;
//        this.username = username;
//        this.score = 0;
//        this.badges = new HashSet<>();
    

//}
