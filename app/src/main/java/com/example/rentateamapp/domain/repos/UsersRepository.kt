package com.example.rentateamapp.domain.repos

import com.example.rentateamapp.data.models.User
import com.example.rentateamapp.domain.sources.UsersFromDbSource
import com.example.rentateamapp.domain.sources.UsersFromServiceSource
import com.example.rentateamapp.presenter.core.ErrorHandler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

interface UsersRepository {
    fun getUsers(): Observable<List<User>>
}

class UsersRepositoryImpl @Inject constructor(
    private val usersFromDbSource: UsersFromDbSource,
    private val usersFromServiceSource: UsersFromServiceSource,
    private val errorHandler: ErrorHandler
) : UsersRepository {
    override fun getUsers(): Observable<List<User>> {
        return usersFromServiceSource
            .getUsersFromService()
            .doOnNext { usersFromDbSource.insertUser(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorComplete { e ->
                errorHandler.handleError(Exception(e))
                false
            }
            .observeOn(Schedulers.io())
            .onErrorResumeNext { usersFromDbSource.getUsers().flatMapIterable { it } }
            .toList()
            .toObservable()
    }

}