package com.johyeonjung.blogfeed.security;

import com.johyeonjung.blogfeed.entity.User;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalUser implements UserDetails {
        private User user;
        private final Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    //닉네임? 이메일?
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public static PrincipalUser getAuthenticatedPrincipalUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (PrincipalUser) authentication.getPrincipal();
    }


}

