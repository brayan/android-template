package br.com.sailboat.template.ui.main.drawer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import br.com.sailboat.template.R
import kotlinx.android.synthetic.main.act_drawer.*

class MainDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, MainDrawerActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_drawer)

        setSupportActionBar(toolbar)

        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.nav_drawer_open, R.string.nav_drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            onClickHome()
            navView.setCheckedItem(R.id.nav_home)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> onClickHome()
            R.id.nav_search -> onClickSearch()
            R.id.nav_item4 -> onClickNavItem4()
            R.id.nav_settings -> onClickSettings()
        }

        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    private fun onClickSettings() {
        Toast.makeText(this, "Navigate to Settings", Toast.LENGTH_SHORT).show()
    }

    private fun onClickNavItem4() {
        Toast.makeText(this, "Item 4", Toast.LENGTH_SHORT).show()
    }

    private fun onClickSearch() {
        supportFragmentManager.beginTransaction().replace(R.id.container, SearchFragment()).commit()
    }

    private fun onClickHome() {
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }

}