package com.example.loyalapi.interfaces.users

import com.example.loyalapi.data.request.users.UserRegisterRequest
import com.example.loyalapi.data.response.users.UserDetailResponse
import com.example.loyalapi.data.response.users.UserResponse
import com.example.loyalapi.entities.users.User
import com.example.loyalapi.wrapper.ApiResponse
import com.example.loyalapi.wrapper.PaginatedResponse
import org.hibernate.engine.jdbc.Size

interface IUserService {
    fun register(request: UserRegisterRequest): ApiResponse<User>
    fun getUserById(userId: Long): ApiResponse<UserDetailResponse>
    fun getAllUsers(pageNumber: Int, pageSize: Int): PaginatedResponse<UserResponse>
}