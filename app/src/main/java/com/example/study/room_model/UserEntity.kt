package com.example.study.room_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="user_table")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String?,
    val age: Int?,
    var phone: String?
)