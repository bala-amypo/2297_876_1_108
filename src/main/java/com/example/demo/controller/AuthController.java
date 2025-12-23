// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtTokenProvider jwtProvider;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(
//             UserService userService,
//             JwtTokenProvider jwtProvider,
//             PasswordEncoder passwordEncoder) {

//         this.userService = userService;
//         this.jwtProvider = jwtProvider;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userService.save(user);
//     }

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody AuthRequest request) {

//         User user = userService.findByEmail(request.email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         if (!passwordEncoder.matches(request.password, user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         String token = jwtProvider.generateToken(
//                 user.getId(), user.getEmail(), user.getRole());

//         AuthResponse response = new AuthResponse();
//         response.token = token;
//         response.userId = user.getId();
//         response.email = user.getEmail();
//         response.role = user.getRole();

//         return response;
//     }
// }
