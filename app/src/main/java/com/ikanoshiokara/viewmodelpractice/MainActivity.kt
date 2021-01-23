package com.ikanoshiokara.viewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(this)
        navigation.selectedItemId = R.id.navigation_count
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_count -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, CountFragment())
                    .commit()
                return true
            }
            R.id.navigation_text -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, TextFragment())
                    .commit()
                return true
            }
        }
        return false
    }
}