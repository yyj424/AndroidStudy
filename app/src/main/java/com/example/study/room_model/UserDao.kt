package com.example.study.room_model;

import androidx.lifecycle.LiveData;
import androidx.room.*

import java.util.List;

@Dao
interface UserDao {
    @Query("select * from user_table order by id asc")
    suspend fun getAllUser() : LiveData<List<UserEntity>>

    @Query("select * from user_table where id=:id")
    suspend fun getUser(id: Int) : UserEntity

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    suspend fun insertUser(userEntity: UserEntity)

    @Update(onConflict = OnConflictStrategy.ROLLBACK)
    suspend fun updateUser(userEntity: UserEntity)

    @Query("delete from user_table where id=:id")
    suspend fun deleteUser(id: Int)
}
