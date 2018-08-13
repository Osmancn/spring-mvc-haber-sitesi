package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(user.getRole().equalsIgnoreCase("ADMIN"))
        {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else if(user.getRole().equalsIgnoreCase("USER")){
            grantedAuthorities.add(new SimpleGrantedAuthority( "ROLE_USER"  ));
        }
        else if(user.getRole().equalsIgnoreCase("GUEST")){
            grantedAuthorities.add(new SimpleGrantedAuthority( "ROLE_GUEST" ));
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getSifre(), grantedAuthorities);
    }
}
