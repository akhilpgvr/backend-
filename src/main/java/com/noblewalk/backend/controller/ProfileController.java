package com.noblewalk.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Operation(summary = "", description = "Endpoint to get the suggested specialist")
    @PostMapping("/create")
    public String createProfile(){
        return "";
    }
}
