package com.example.loyalapi.controller.users

import com.example.loyalapi.config.ApiConfig
import com.example.loyalapi.data.request.users.UserRegisterRequest
import com.example.loyalapi.data.response.users.UserDetailResponse
import com.example.loyalapi.data.response.users.UserResponse
import com.example.loyalapi.entities.users.User
import com.example.loyalapi.interfaces.users.IUserService
import com.example.loyalapi.wrapper.ApiResponse
import com.example.loyalapi.wrapper.PaginatedResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ApiConfig.USER_API_PATH)
class UserController(private val userService: IUserService) {

    @PostMapping("login")
    fun login(@RequestBody request: UserRegisterRequest): ApiResponse<User> {
        return userService.register(request);
    }

    @GetMapping("user/{userId}")
    fun getUserById(@PathVariable userId: Long): ApiResponse<UserDetailResponse> {
        return userService.getUserById(userId);
    }

    @GetMapping("users")
    fun getAllUsers(
        @RequestParam(defaultValue = "1") pageNumber: Int, @RequestParam(defaultValue = "10") pageSize: Int
    ): PaginatedResponse<UserResponse> {
        return userService.getAllUsers(pageNumber, pageSize); }
}