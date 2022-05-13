package com.codegym.cinema.service.impl;

import com.codegym.cinema.entity.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MyUserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private Boolean enabled = true;

    @JsonIgnore
    private String password;
    Set<GrantedAuthority> authorities = null;

    public MyUserDetailsImpl(String username, String password,
                              Set<GrantedAuthority> authorities, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }
    // This func help you guys get account information to AccountDetailService
    public static MyUserDetailsImpl build(Account account) {
        Set<GrantedAuthority> authorities = account.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().getRoleName()))
                .collect(Collectors.toSet());
        return new MyUserDetailsImpl(
                account.getUsername(),
                account.getPassword(),
                authorities,
                account.getIsEnable());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyUserDetailsImpl account = (MyUserDetailsImpl) o;
        return Objects.equals(username, account.getUsername());
    }
}
