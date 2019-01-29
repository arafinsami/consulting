package com.consulting.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.consulting.models.*;
import com.consulting.repositories.*;

public class UserDetailsServiceImpl implements UserDetailsService{
	
    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRole userRole : user.getUserRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
