package br.com.sailboat.template.main.bottom

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.sailboat.template.R
import br.com.sailboat.template.main.drawer.HomeFragment
import br.com.sailboat.template.main.drawer.SearchFragment
import br.com.sailboat.template.main.drawer.SettingsFragment
import kotlinx.android.synthetic.main.act_bottom.*

class MainBottomActivity : AppCompatActivity() {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, MainBottomActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_bottom)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> onClickHome()
                R.id.nav_search -> onClickSearch()
                R.id.nav_settings -> onClickSettings()
            }
            true
        }

        if (savedInstanceState == null) {
            onClickHome()
        }
    }

    private fun onClickHome() {
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }

    private fun onClickSearch() {
        supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment()).commit()
    }

    private fun onClickSettings() {
        supportFragmentManager.beginTransaction().replace(R.id.container, SettingsFragment()).commit()
    }

}