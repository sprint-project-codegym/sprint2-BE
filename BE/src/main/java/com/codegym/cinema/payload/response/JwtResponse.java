package com.codegym.cinema.payload.response;

import com.codegym.cinema.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class JwtResponse {
    private String jwtToken;
    private User user;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String jwtToken, User user, Collection<? extends GrantedAuthority> authorities) {
        this.jwtToken = jwtToken;
        this.user = user;
        this.authorities = authorities;

        this.user.getAccount().setPassword(null); // hide password
        this.user.getAccount().setVerificationCode(null); // hide verify code
    }
}
