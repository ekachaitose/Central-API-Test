package com.example.CentralTest.config

import com.example.CentralTest.client.RandomUserClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(
    clients = [RandomUserClient::class]
)
 class RandomUserClientConfiguration