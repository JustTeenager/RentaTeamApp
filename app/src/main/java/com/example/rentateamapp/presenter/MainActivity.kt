package com.example.rentateamapp.presenter

import android.os.Bundle
import com.example.rentateamapp.R
import com.example.rentateamapp.databinding.ActivityMainBinding
import com.example.rentateamapp.presenter.core.Router
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() = with(binding.bottomNavigation) {
        setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_nav_item_about -> router.showAboutFragment(supportFragmentManager)
                R.id.bottom_nav_item_list -> router.showUsersListFragment(supportFragmentManager)
            }
            true
        }
        selectedItemId = R.id.bottom_nav_item_list
    }
}