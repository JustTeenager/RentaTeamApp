package com.example.rentateamapp.domain.sources

import com.example.rentateamapp.data.db.UsersDao
import com.example.rentateamapp.data.models.User
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface UsersFromDbSource {
    fun getUsers(): Observable<List<User>>

    fun insertUser(user: User)
}

class UsersFromDbSourceImpl @Inject constructor(
    private val usersDao: UsersDao
) : UsersFromDbSource {

    override fun getUsers(): Observable<List<User>> = usersDao.getUsers().toObservable()

    override fun insertUser(user: User) = usersDao.insertUser(user)
}