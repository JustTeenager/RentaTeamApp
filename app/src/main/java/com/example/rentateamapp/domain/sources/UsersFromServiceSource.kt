package com.example.rentateamapp.domain.sources

import com.example.rentateamapp.data.api.RentaTeamApi
import com.example.rentateamapp.data.mappers.RemoteResponseToUsersListMapper
import com.example.rentateamapp.data.models.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable
import javax.inject.Inject

interface UsersFromServiceSource {
    fun getUsersFromService(): Observable<User>
}

class UsersFromServiceSourceImpl @Inject constructor(
    private val rentaTeamApi: RentaTeamApi,
    private val toUsersListMapper: RemoteResponseToUsersListMapper
) : UsersFromServiceSource {

    override fun getUsersFromService(): Observable<User> {
        return rentaTeamApi.getUsers()
            .map(toUsersListMapper)
            .flatMapObservable { it.toObservable() }
    }

}