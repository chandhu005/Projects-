package com.springboot.Blog.service.impl;

import com.springboot.Blog.Security.JwtTokenProvider;
import com.springboot.Blog.entity.Role;
import com.springboot.Blog.entity.User;
import com.springboot.Blog.exception.BlogApiException;
import com.springboot.Blog.payLoad.LoginDto;
import com.springboot.Blog.payLoad.RegisterDto;
import com.springboot.Blog.repository.RoleRepository;
import com.springboot.Blog.repository.UserRepository;
import com.springboot.Blog.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider=jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token=jwtTokenProvider.generateToken(authentication);
        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {
        //add check for username exists in databaseornot
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST,"Username is already exists!");
        }
        //add check for email Exists
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw  new BlogApiException(HttpStatus.BAD_REQUEST,"Email is Already Exists!");
        }
        User user=new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Set<Role> roles=new HashSet<>();
        Role userrole=roleRepository.findByName("ROLE_USER").get();
        roles.add(userrole);
        user.setRoles(roles);
        userRepository.save(user);
        return "user Registered Sucessfully!";
    }
}
