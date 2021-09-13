package com.example.rentateamapp.presenter.core

import androidx.fragment.app.FragmentManager
import com.example.rentateamapp.R
import com.example.rentateamapp.data.models.User
import com.example.rentateamapp.presenter.about.AboutFragment
import com.example.rentateamapp.presenter.user_details.UserDetailsFragment
import com.example.rentateamapp.presenter.users_list.UsersListFragment
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class Router @Inject constructor() {
    private fun showFragment(
        fm: FragmentManager,
        fragment: DaggerFragment,
        addToBackStack: Boolean = false
    ) {
        fm.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .apply { if (addToBackStack) addToBackStack(null) }
            .setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            .commit()
    }

    fun showAboutFragment(fm: FragmentManager) {
        clearBackStack(fm)
        showFragment(fm, AboutFragment())
    }

    fun showUsersListFragment(fm: FragmentManager) {
        clearBackStack(fm)
        showFragment(fm, UsersListFragment())
    }

    fun showUserDetailsFragment(fm: FragmentManager, user: User) {
        showFragment(fm, UserDetailsFragment.getInstance(user), true)
    }

    private fun clearBackStack(fm: FragmentManager) {
        for (i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }
}