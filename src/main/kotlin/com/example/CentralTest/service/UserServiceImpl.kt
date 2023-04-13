package com.example.CentralTest.service

import com.example.CentralTest.client.RandomUserClient
import com.example.CentralTest.model.response.UserResponse
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (private val randomUserClient: RandomUserClient) : UserService{
    override fun getUser(seed: String): UserResponse {
        val result = randomUserClient.randomUser(seed).results
        val user = result!![0]
        return UserResponse(
            firstName = user.name?.first,
            lastName = user.name?.last,
            gender = user.gender,
            email = user.email
        )
    }
}