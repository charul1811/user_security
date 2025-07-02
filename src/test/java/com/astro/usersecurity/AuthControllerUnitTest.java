package com.astro.usersecurity;

import com.astro.usersecurity.controller.AuthController;
import com.astro.usersecurity.payload.LoginRequest;
import com.astro.usersecurity.payload.SignupRequest;
import com.astro.usersecurity.repository.RoleRepository;
import com.astro.usersecurity.repository.UserRepository;
import com.astro.usersecurity.security.JwtUtils;
import com.astro.usersecurity.service.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static java.sql.DriverManager.println;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthControllerUnitTest {

    private AuthController authController;
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder encoder;
    private JwtUtils jwtUtils;

    @BeforeEach
    void setup() {
        authenticationManager = mock(AuthenticationManager.class);
        userRepository = mock(UserRepository.class);
        roleRepository = mock(RoleRepository.class);
        encoder = mock(PasswordEncoder.class);
        jwtUtils = mock(JwtUtils.class);

        authController = new AuthController();

        // Manually inject mocks
        injectDependencies();
    }

    void injectDependencies() {
        // Use reflection for private field injection (or use a constructor in AuthController)
        setField(authController, "authenticationManager", authenticationManager);
        setField(authController, "userRepository", userRepository);
        setField(authController, "roleRepository", roleRepository);
        setField(authController, "encoder", encoder);
        setField(authController, "jwtUtils", jwtUtils);
    }

    void setField(Object target, String fieldName, Object value) {
        try {
            var field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRegisterUser_Success() {
        SignupRequest request = new SignupRequest();
        request.setUsername("john123");
        request.setEmail("john123@example.com");
        request.setPassword("password123");
       // request.setRole(Set.of("user"));

        when(userRepository.existsByUsername("john123")).thenReturn(false);
        when(userRepository.existsByEmail("john123@example.com")).thenReturn(false);
        when(encoder.encode("password123")).thenReturn("encodedPwd");
       // when(roleRepository.findByName(ERole.ROLE_USER))
                //.thenReturn(Optional.of(new Role(ERole.ROLE_USER)));

        ResponseEntity<?> response = authController.registerUser(request);

        assertEquals(200, response.getStatusCodeValue());
        println(response.getBody().toString());
        System.out.println(response.getBody().toString());
      //  assertTrue(response.getBody().toString().contains("User registered successfully!"));
    }

    @Test
    void testAuthenticateUser_Success() {
        LoginRequest loginRequest = new LoginRequest();                                                                                                                                                                                                                                                                                                                                                                                                  
       loginRequest.setEmail ("john123@example.com");
        loginRequest.setPassword("password123");

        UserDetailsImpl userDetails = new UserDetailsImpl(
                1L, "john123", "john123@example.com", "encodedPwd", Collections.emptyList());

        Authentication auth = mock(Authentication.class);

        when(authenticationManager.authenticate(any())).thenReturn(auth);
        when(auth.getPrincipal()).thenReturn(userDetails);
        when(jwtUtils.generateJwtToken(auth)).thenReturn("mock-jwt-token");

        ResponseEntity<?> response = authController.authenticateUser(loginRequest);

        assertEquals(200, response.getStatusCodeValue());
        System.out.println(response.getBody().toString());
       // assertTrue(response.getBody().toString().contains("mock-jwt-token"));
    }
}
