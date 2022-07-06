package com.example.study.room_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="board_table")
data class BoardEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var content: String?,
    var category: String?
)