package com.example.CentralTest.service

import com.example.CentralTest.model.response.UserResponse

public interface UserService {
    fun getUser(seed: String) : UserResponse
}