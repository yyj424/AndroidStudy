package com.example.study.room_model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [UserEntity::class, BoardEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() { //이게 약간 DBHelper같은 느낌?
    abstract fun userDao(): UserDao
    abstract fun boardDao(): BoardDao

    companion object {
        @Volatile //java 변수를 main memory에 저장
        private var dataBase: AppDatabase? = null
        fun getDataBase(context: Context, scope: CoroutineScope): AppDatabase {
            return dataBase ?: synchronized(this) {
                val db =
                    Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "db")
                        .addCallback(AppDatabaseCallback(scope))
                        .fallbackToDestructiveMigration()
                        .build()
                dataBase = db
                db
            }
        }
    }

    private class AppDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //DB가 처음 생성되었을 때 동작(ex default data 넣기)
            //insert 같은거 하려면 coroutine 쓰는 듯
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            //DB가 열릴 때마다 할 동작
        }
    }
}