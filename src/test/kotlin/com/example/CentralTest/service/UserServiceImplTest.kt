package com.example.CentralTest.service

import com.example.CentralTest.client.RandomUserClient
import com.example.CentralTest.model.Name
import com.example.CentralTest.model.Results
import com.example.CentralTest.model.response.UserRandomResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions

@ExtendWith(MockitoExtension::class)
class UserServiceImplTest {
    @Mock
    lateinit var randomUserClient: RandomUserClient
    @InjectMocks
    lateinit var userServiceImpl: UserServiceImpl

    @Nested
    inner class GetUserTest {

        private val userRandomResponse = UserRandomResponse(
            results = listOf(
                Results(
                    gender = "gender",
                    email = "email",
                    name = Name(
                        title = "title",
                        first = "first",
                        last = "last"
                    )
                )
            )
        )

        private val userRandomResponseNull = UserRandomResponse(
            results = null
        )

        @Test
        fun whenGetUserThenSuccess() {
            whenever(randomUserClient.randomUser(any())).thenReturn(userRandomResponse)
            val actual = userServiceImpl.getUser("momo")
            assertEquals("first", actual.firstName)
            assertEquals("last", actual.lastName)
            assertEquals("gender", actual.gender)
            assertEquals("email", actual.email)
        }

        @Test
        fun whenGetUserThenReturnNull() {
            whenever(randomUserClient.randomUser(any())).thenReturn(userRandomResponseNull)
            Assertions.assertThrows(IllegalArgumentException::class.java) {
                userServiceImpl.getUser("momo")
            }
        }

    }
}