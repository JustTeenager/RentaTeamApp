package com.example.rentateamapp.di.modules

import android.content.Context
import androidx.room.Room
import com.example.rentateamapp.data.db.UsersDb
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun provideUsersDB(context: Context) =
        Room.databaseBuilder(
            context,
            UsersDb::class.java,
            "users.db"
        ).build()

    @Provides
    fun provideUsersDao(db: UsersDb) = db.getUsersDao()
}