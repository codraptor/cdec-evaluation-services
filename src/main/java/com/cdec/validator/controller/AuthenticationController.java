package com.cdec.validator.controller;

import com.cdec.validator.model.request.LoginRequest;
import com.cdec.validator.model.response.LoginResponse;
import com.cdec.validator.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) throws Exception {
        ResponseEntity<LoginResponse> response = ResponseEntity.ok(authenticationService.login(request));
        return response;
    }

}
