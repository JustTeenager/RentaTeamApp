package com.example.rentateamapp.presenter.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.rentateamapp.di.core.ViewModelFactory
import dagger.android.support.DaggerFragment
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>
    (private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ViewBinding) :
    DaggerFragment() {

    protected lateinit var binding: VB

    protected val viewModel by lazy { generateViewModel() }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var vmFactory: ViewModelFactory

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater, container, false) as VB
        return binding.root
    }

    @Suppress("UNCHECKED_CAST")
    private fun generateViewModel(): VM {
        val vmClass = (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[1] as Class<ViewModel>
        return vmFactory.create(vmClass as Class<VM>)
    }
}