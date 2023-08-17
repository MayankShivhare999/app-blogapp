package com.sample.blogapp.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
@AllArgsConstructor
public class CreateUserRequest {

    private String username;
    private String password;
    private String email;
}
