package com.example.rentateamapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.rentateamapp.di.core.ViewModelKey
import com.example.rentateamapp.presenter.users_list.UsersListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {

    @IntoMap
    @ViewModelKey(UsersListViewModel::class)
    @Binds
    fun provideUsersListViewModel(usersListViewModel: UsersListViewModel): ViewModel
}