package com.example.loyalapi.data.response.users

import java.time.LocalDateTime

data class UserDetailResponse(
    val id: Long,
    val email: String,
    val userName: String,
    val role: String,
    val firstName: String,
    val lastName: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val firstLogin: LocalDateTime,
    val lastLogin: LocalDateTime
);