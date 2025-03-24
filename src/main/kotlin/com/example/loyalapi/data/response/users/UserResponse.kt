package com.example.loyalapi.data.response.users

import java.time.LocalDateTime

data class UserResponse(
    val id: Long,
    val email: String,
    val username: String,
    val firstName: String,
    val lastName: String,
    val createdAt: LocalDateTime,
);