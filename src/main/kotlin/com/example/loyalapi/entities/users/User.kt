package com.example.loyalapi.entities.users

import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    val userId: Long = 0,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = true)
    val role: String,

    @Column(nullable = true)
    val firstName: String,

    @Column(nullable = true)
    val lastName: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "first_login")
    val firstLogin: LocalDateTime = LocalDateTime.now(),

    @Column(name = "last_login")
    val lastLogin: LocalDateTime = LocalDateTime.now()


)