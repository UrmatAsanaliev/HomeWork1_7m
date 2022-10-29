package com.example.homework1_7m.presentation.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.homework1_7m.R
import com.example.homework1_7m.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment_activity_main)}

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val navView: BottomNavigationView = binding.navView


            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.firstFragment,
                    R.id.basketOriginFragment,
                    R.id.bestsellersFragment,
                    R.id.myAccFragment
                )
            )
            //  setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
            navController.addOnDestinationChangedListener { _, _, _ ->
                if (navController.currentDestination?.id == R.id.firstFragment
                    || navController.currentDestination?.id == R.id.restorePasswordFragment
                    || navController.currentDestination?.id == R.id.thirdFragment
                    || navController.currentDestination?.id == R.id.getCodeFragment
                    || navController.currentDestination?.id == R.id.interFragment
                    || navController.currentDestination?.id == R.id.newPasswordCreateFragment
                    || navController.currentDestination?.id == R.id.sortFragment
                ) {
                    binding.navView.visibility = View.GONE
                } else {
                    binding.navView.visibility = View.VISIBLE
                }
            }
        }
    }
