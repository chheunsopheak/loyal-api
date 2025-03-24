package com.example.loyalapi.data.request.users

data class UserRegisterRequest(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
);