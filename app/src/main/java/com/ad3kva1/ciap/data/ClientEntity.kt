package com.ad3kva1.ciap.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients")
data class ClientEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val fullName: String,
    val visitsCount: Int = 0,
    val isArchived: Boolean = false
)
