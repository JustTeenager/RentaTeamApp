package com.example.rentateamapp.di.core

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Retention
annotation class ActivityScope

@Scope
@Retention
annotation class FragmentScope

@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)