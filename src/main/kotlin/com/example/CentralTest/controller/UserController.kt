package com.example.CentralTest.controller

import com.example.CentralTest.model.response.UserResponse
import com.example.CentralTest.service.UserService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
public class UserController(
    private val _userService : UserService
) {
    @GetMapping(
        value = ["/v1/users/{seed}"]
    )
    fun getUser(
        @PathVariable("seed") seed: String
    ): ResponseEntity<UserResponse> {
        return ResponseEntity<UserResponse>(_userService.getUser(seed), HttpHeaders(), HttpStatus.OK)
    }
}