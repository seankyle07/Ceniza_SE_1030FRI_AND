package com.ceniza.bottomnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_calculator -> selectedFragment = CalculatorFragment()
                R.id.nav_list -> selectedFragment = ListFragment()
                R.id.nav_profile -> selectedFragment = ProfileFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, selectedFragment!!)
                .commit()
            true
        }


        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.nav_profile
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment())
                .commit()
        }
    }
}