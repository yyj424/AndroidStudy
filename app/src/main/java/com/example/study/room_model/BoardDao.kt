package com.example.study.room_model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BoardDao {
    @Query("select * from board_table order by id desc")
    suspend fun getAllBoard():LiveData<List<BoardEntity>>

    @Query("select * from board_table where id=:id")
    suspend fun getBoard(id:Int):BoardEntity

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    suspend fun insertBoard(boardEntity: BoardEntity)

    @Update(onConflict = OnConflictStrategy.ROLLBACK)
    suspend fun updateBoard(boardEntity: BoardEntity)

    @Query("delete from board_table where id=:id")
    suspend fun deleteBoard(id:Int)
}