package com.company.controller;

import com.company.dto.RegistrationDto;
import com.company.dto.SmsDTO;
import com.company.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Api(tags = "For Authorization")
public class AuthController {

    private final AuthService authService;

    @ApiOperation(value = "registration", notes = "Method for registration", nickname = "Mazgi")
    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody @Valid RegistrationDto dto) {
        log.info("registration: {}", dto);
        authService.registration(dto);
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "activation", notes = "Method for activation", nickname = "Mazgi")
    @PostMapping("/activation")
    public ResponseEntity<?> activisation(@RequestBody @Valid SmsDTO dto) {
        log.info("registration: {}", dto);
        return ResponseEntity.ok(authService.activation(dto));
    }
}