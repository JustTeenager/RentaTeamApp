package com.example.rentateamapp.di.modules

import com.example.rentateamapp.di.core.ActivityScope
import com.example.rentateamapp.di.core.FragmentScope
import com.example.rentateamapp.presenter.MainActivity
import com.example.rentateamapp.presenter.about.AboutFragment
import com.example.rentateamapp.presenter.user_details.UserDetailsFragment
import com.example.rentateamapp.presenter.users_list.UsersListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ScreensModule {

    @ContributesAndroidInjector
    @ActivityScope
    fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    @FragmentScope
    fun contributeListFragment(): UsersListFragment

    @ContributesAndroidInjector
    @FragmentScope
    fun contributeAboutFragment(): AboutFragment

    @ContributesAndroidInjector
    @FragmentScope
    fun contributeUserDetailsFragment(): UserDetailsFragment
}