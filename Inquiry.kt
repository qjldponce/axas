package com.example.prelim.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inquiry_table")
data class Inquiry(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val inquiry: String
)