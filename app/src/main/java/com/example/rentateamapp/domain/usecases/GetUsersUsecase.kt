package com.example.rentateamapp.domain.usecases

import com.example.rentateamapp.data.models.User
import com.example.rentateamapp.domain.repos.UsersRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface GetUsersUsecase {
    operator fun invoke(): Observable<List<User>>
}

class GetUsersUsecaseImpl @Inject constructor(
    private val usersRepository: UsersRepository
) : GetUsersUsecase {
    override fun invoke(): Observable<List<User>> = usersRepository.getUsers()
}