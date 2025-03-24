package com.example.loyalapi.entities.transactions

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "transactions")
data class Transaction(
    @Id
    @GeneratedValue(generator = "transaction_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "transaction_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "type", nullable = false)
    val type: Int,

    @Column(nullable = false)
    val points: Int,

    @Column(nullable = false)
    val description: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now()
)