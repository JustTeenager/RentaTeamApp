package com.example.rentateamapp.presenter.core

import com.example.rentateamapp.di.core.AppComponent
import com.example.rentateamapp.di.core.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    private var appComponent: AppComponent? = null

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent ?: DaggerAppComponent
            .builder()
            .context(this.applicationContext)
            .build()
            .also { appComponent = it }
    }
}