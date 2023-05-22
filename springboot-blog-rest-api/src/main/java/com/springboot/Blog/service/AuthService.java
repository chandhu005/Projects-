package com.springboot.Blog.service;

import com.springboot.Blog.payLoad.LoginDto;
import com.springboot.Blog.payLoad.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
