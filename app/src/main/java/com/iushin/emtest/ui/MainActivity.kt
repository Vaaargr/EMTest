package com.iushin.emtest.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.iushin.emtest.R
import com.iushin.emtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterChanger {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)
    }

    private fun changeBubble(count: Int) {
        if (count < 1) {
            binding.bubble.isVisible = false
        } else {
            binding.bubble.isVisible = true
            binding.bubble.text = count.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun countChange(newCount: Int) {
        changeBubble(newCount)
    }
}