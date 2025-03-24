package com.example.loyalapi.repositories.users

import com.example.loyalapi.entities.users.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}