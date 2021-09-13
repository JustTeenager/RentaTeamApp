package com.example.rentateamapp.di.modules

import com.example.rentateamapp.domain.repos.UsersRepository
import com.example.rentateamapp.domain.repos.UsersRepositoryImpl
import com.example.rentateamapp.domain.sources.UsersFromDbSource
import com.example.rentateamapp.domain.sources.UsersFromDbSourceImpl
import com.example.rentateamapp.domain.sources.UsersFromServiceSource
import com.example.rentateamapp.domain.sources.UsersFromServiceSourceImpl
import com.example.rentateamapp.domain.usecases.GetUsersUsecase
import com.example.rentateamapp.domain.usecases.GetUsersUsecaseImpl
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        DbModule::class,
    ]
)
interface ContractsModule {

    @Binds
    fun bindUsersFromServiceSource(impl: UsersFromServiceSourceImpl): UsersFromServiceSource

    @Binds
    fun bindUsersFromDbSource(impl: UsersFromDbSourceImpl): UsersFromDbSource

    @Binds
    fun bindUsersUsersRepository(impl: UsersRepositoryImpl): UsersRepository

    @Binds
    fun bindGetUsersUseCase(impl: GetUsersUsecaseImpl): GetUsersUsecase

}