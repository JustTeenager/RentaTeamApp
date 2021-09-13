package com.example.rentateamapp.presenter.core

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.rentateamapp.R
import retrofit2.HttpException
import javax.inject.Inject

class ErrorHandler @Inject constructor(
    private val context: Context
) {
    fun handleError(exception: Exception) {
        when (exception) {
            is HttpException -> {
                showToast(R.string.server_error)
            }
            else -> {
                showToast(R.string.connection_error)
            }
        }
    }

    private fun showToast(@StringRes error: Int) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}