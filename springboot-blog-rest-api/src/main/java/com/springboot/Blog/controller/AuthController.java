package com.springboot.Blog.controller;

import com.springboot.Blog.payLoad.JWTAuthResponse;
import com.springboot.Blog.payLoad.LoginDto;
import com.springboot.Blog.payLoad.RegisterDto;
import com.springboot.Blog.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    //Build Login RestApi
    @PostMapping(value={"/login","/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        String token=authService.login(loginDto);
        JWTAuthResponse jwtAuthResponse=new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return  ResponseEntity.ok(jwtAuthResponse);
    }
    //Build register REST API
    @PostMapping(value={"register","/signup"})
    public  ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response=authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
