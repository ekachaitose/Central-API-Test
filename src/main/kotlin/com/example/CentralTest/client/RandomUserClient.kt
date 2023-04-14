package com.example.CentralTest.client

import com.example.CentralTest.model.response.UserRandomResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    value = "randomUser",
    url = "\${randomUser.url}",
)
public interface  RandomUserClient {
    @GetMapping(value = ["/api/"])
    fun randomUser(
        @RequestParam(value = "seed") seed: String,
    ): UserRandomResponse
}