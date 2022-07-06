package com.example.study.room_model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class, BoardEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun boardDao(): BoardDao
    //onCreate - DB 최초 생성 시

    //onOpen - DB 열릴 때 마다
}