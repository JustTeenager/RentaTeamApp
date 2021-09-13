package com.example.rentateamapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rentateamapp.data.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UsersDb : RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}