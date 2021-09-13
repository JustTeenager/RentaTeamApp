package com.example.rentateamapp.presenter.user_details

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.rentateamapp.data.models.User
import com.example.rentateamapp.databinding.FragmentUserDetailsBinding
import com.example.rentateamapp.presenter.core.BaseFragment
import com.example.rentateamapp.presenter.core.GlideManager
import javax.inject.Inject

class UserDetailsFragment : BaseFragment<FragmentUserDetailsBinding, Nothing>
    (FragmentUserDetailsBinding::inflate) {

    @Inject
    lateinit var glideManager: GlideManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = requireArguments().getParcelable(USER_KEY) as User?
        setupUI(user)
    }

    private fun setupUI(user: User?) = with(binding) {
        glideManager.loadAvatar(user?.avatar, ivPhoto)
        user?.firstName.let { tvName.text = it }
        user?.lastName.let { tvSecondName.text = it }
        user?.email.let { tvEmail.text = it }
    }

    companion object {
        private const val USER_KEY = "user_key"
        fun getInstance(user: User) = UserDetailsFragment().apply {
            this.arguments = bundleOf(USER_KEY to user)
        }
    }
}