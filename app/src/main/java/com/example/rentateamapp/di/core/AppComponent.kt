package com.example.rentateamapp.di.core

import android.content.Context
import com.example.rentateamapp.di.modules.ContractsModule
import com.example.rentateamapp.di.modules.ScreensModule
import com.example.rentateamapp.di.modules.ViewModelsModule
import com.example.rentateamapp.presenter.core.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ScreensModule::class,
        ViewModelsModule::class,
        ContractsModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent

    }
}