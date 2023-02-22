package com.will.dawnpatrol.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author willw
 * Implements UserDetails for use in Spring Security.
 * Its primary use in the application is to map a User to an AuthUser so that it can be processed by Spring Security.
 *
 */
public class AuthUser implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

    public AuthUser(User user){
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
        return true;
    }
}
