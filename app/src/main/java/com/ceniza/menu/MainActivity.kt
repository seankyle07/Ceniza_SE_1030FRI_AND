package com.ceniza.menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AnotherFragment())
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_go_to_fragment -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AnotherFragment())
                    .addToBackStack(null)
                    .commit()
                true
            }
            R.id.action_show_dialog -> {
                MyDialogFragment().show(supportFragmentManager, "dialog")
                true
            }
            R.id.action_exit_app -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
