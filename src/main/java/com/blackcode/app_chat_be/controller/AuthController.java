package com.blackcode.app_chat_be.controller;

import com.blackcode.app_chat_be.dto.user.*;
import com.blackcode.app_chat_be.exception.TokenRefreshException;
import com.blackcode.app_chat_be.model.UserRefreshToken;
import com.blackcode.app_chat_be.model.UserToken;
import com.blackcode.app_chat_be.model.Users;
import com.blackcode.app_chat_be.repository.UserRepository;
import com.blackcode.app_chat_be.repository.UserTokenRepository;
import com.blackcode.app_chat_be.security.jwt.JwtUtils;
import com.blackcode.app_chat_be.security.service.UserDetailsImpl;
import com.blackcode.app_chat_be.security.service.UserRefreshTokenService;
import com.blackcode.app_chat_be.security.service.UserTokenService;
import com.blackcode.app_chat_be.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth/user")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginReq loginRequest){
        try {
            JwtRes response = authService.authenticateUser(loginRequest);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (AccountExpiredException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Account has expired");
        } catch (LockedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account is locked");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login error");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpReq signupRequest){
        try {
            return ResponseEntity.ok(authService.registerUser(signupRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageRes(e.getMessage()));
        }
    }

    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshReq request){
        try {
            return ResponseEntity.ok(authService.refreshToken(request));
        } catch (TokenRefreshException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signout(
            HttpServletRequest request,
            HttpServletResponse response) {
        return ResponseEntity.ok(authService.logout(request));
    }
}
