package com.example.rest_demo.Service;

import com.example.rest_demo.Model.Role;
import com.example.rest_demo.Model.UserEntity;
import com.example.rest_demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomUserDetailService implements UserDetailsService{

    private UserRepository userRepository;
    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity user=userRepository.findByUserName(username).orElseThrow(()->new UsernameNotFoundException
            ("Username not found"));
    return new User(user.getUserName(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRole()));
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return  roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}