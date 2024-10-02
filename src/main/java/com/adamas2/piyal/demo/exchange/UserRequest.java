package com.adamas2.piyal.demo.exchange;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @NotNull(message="ID is mandatory")
    private String userId;

    @NotNull(message="Name is mandatory")
    private String userName;

}

