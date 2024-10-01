package com.adamas2.piyal.demo.entity;


import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;
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
