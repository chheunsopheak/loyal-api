package com.example.loyalapi.service.users

import com.example.loyalapi.data.request.users.UserLoginRequest
import com.example.loyalapi.data.request.users.UserRegisterRequest
import com.example.loyalapi.data.response.users.UserDetailResponse
import com.example.loyalapi.data.response.users.UserResponse
import com.example.loyalapi.entities.users.User
import com.example.loyalapi.interfaces.users.IUserService
import com.example.loyalapi.repositories.users.UserRepository
import com.example.loyalapi.wrapper.ApiResponse
import com.example.loyalapi.wrapper.PaginatedResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(
    @Autowired private val userRepository: UserRepository
) : IUserService {
    override fun register(request: UserRegisterRequest): ApiResponse<User> {

        // Check if user already exists
        val existingUser = userRepository.findByEmail(request.email)
        if (existingUser != null) {
            return ApiResponse.failed(400, "User already exists")
        }

        val user = User(
            email = request.email,
            password = request.password,
            firstName = request.firstName,
            lastName = request.lastName,
            username = request.email,
            role = "USER",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
            firstLogin = LocalDateTime.now(),
            lastLogin = LocalDateTime.now()
        )
        val savedUser = userRepository.save(user)
        return ApiResponse.success(savedUser, "User registered successfully")
    }

    override fun getUserById(userId: Long): ApiResponse<UserDetailResponse> {
        val user = userRepository.findById(userId).orElse(null) ?: return ApiResponse.notFound("User not found")

        val userDetail = UserDetailResponse(
            id = user.id,
            email = user.email,
            userName = user.username,
            role = user.role,
            firstName = user.firstName,
            lastName = user.lastName,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt,
            firstLogin = user.firstLogin,
            lastLogin = user.lastLogin
        )
        return ApiResponse.success(userDetail, "User retrieved successfully")
    }

    override fun getAllUsers(pageNumber: Int, pageSize: Int): PaginatedResponse<UserResponse> {
        val pageable = PageRequest.of(pageNumber - 1, pageSize)

        val userPage = userRepository.findAll(pageable)


        val userResponses = userPage.content.map { user ->
            UserResponse(
                id = user.id,
                email = user.email,
                userName = user.username,
                firstName = user.firstName,
                lastName = user.lastName,
                createdAt = user.createdAt
            )
        }

        val paginatedResponse = PaginatedResponse.success(
            data = userResponses,
            currentPage = pageNumber,
            pageSize = pageSize,
            totalItems = userPage.totalElements.toInt()
        )
        return paginatedResponse;
    }
}