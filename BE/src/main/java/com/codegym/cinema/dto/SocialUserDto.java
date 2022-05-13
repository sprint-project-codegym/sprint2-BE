package com.codegym.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SocialUserDto {
    private String provider;
    private String id;
    private String email;
    private String name;
    private String photoUrl;
    private String firstName;
    private String lastName;
    private String authToken;
    private String idToken;
    private String authorizationCode;
    private Object response;
}
