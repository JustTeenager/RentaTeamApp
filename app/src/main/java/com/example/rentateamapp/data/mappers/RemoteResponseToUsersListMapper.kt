package com.example.rentateamapp.data.mappers

import com.example.rentateamapp.data.models.RemoteServiceResponse
import com.example.rentateamapp.data.models.User
import javax.inject.Inject

class RemoteResponseToUsersListMapper
@Inject constructor() : (RemoteServiceResponse) -> List<User> {
    override fun invoke(p1: RemoteServiceResponse): List<User> = p1.data
}