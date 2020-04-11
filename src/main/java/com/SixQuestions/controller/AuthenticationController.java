package com.SixQuestions.controller;

import com.SixQuestions.dto.AuthenticationRequestDto;
import com.SixQuestions.model.User;
import com.SixQuestions.security.jwt.JwtTokenProvider;
import com.SixQuestions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthenticationController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping(value = "/login")
    public String createLoginForm() {
        return "/login";
    }

    @GetMapping("/")
    public String startPage() {
        return createLoginForm();
    }

    @GetMapping(value = "/registration")
    public String createRegistrationForm() {
        return "/registration";
    }

    @GetMapping(value = "/main-page")
    public String createMainPageForm() {
        return "/main-page";
    }

//    @PostMapping(value = "/login")
//    public String login(AuthenticationRequestDto requestDto) {
//
//        try {
//            String username = requestDto.getUsername();
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
//            User user = userService.findByUsername(username);
//
//            if (user == null) {
//                throw new UsernameNotFoundException("User with username: " + username + " not found");
//            }
//
//            String token = jwtTokenProvider.createToken(username, user.getRoles());
//
//            Map<Object, Object> response = new HashMap<>();
//            response.put("username", username);
//            response.put("token", token);
//
//            return "/main-page";
//
//        } catch (AuthenticationException e) {
//            return "/login?error";
//        }
//    }


}

