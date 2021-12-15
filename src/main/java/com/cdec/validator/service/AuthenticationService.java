package com.cdec.validator.service;

import com.cdec.validator.exception.ErrorCode;
import com.cdec.validator.exception.ServiceException;
import com.cdec.validator.model.ResponseStatus;
import com.cdec.validator.model.request.LoginRequest;
import com.cdec.validator.model.response.LoginResponse;
import com.cdec.validator.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;

    public AuthenticationService(AuthenticationManager authenticationManager,
                                 @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
                                 JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public String authenticate(String username, String password) {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    username, password));

        } catch (BadCredentialsException ex) {
            throw new ServiceException(ErrorCode.EMAIL_PASSWORD_INCORRECT, ex);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtUtil.generateToken(userDetails);
        return token;

    }

    public LoginResponse login(LoginRequest request) throws Exception {

        try {

            String jwt = authenticate(request.getUsername(), request.getPassword());

            LoginResponse response = LoginResponse.builder()
                    .jwt(jwt)
                    .status(ResponseStatus.SUCCESS).build();

            return response;

        } catch (ServiceException e) {
            return LoginResponse.builder().status(ResponseStatus.FAILURE)
                    .code(e.getErrorCode().getCode())
                    .message(e.getMessage()).build();
        }

    }

}
