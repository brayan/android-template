package br.com.sailboat.template.ui.main.tabs

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.sailboat.template.ui.main.drawer.HomeFragment
import br.com.sailboat.template.ui.main.drawer.SearchFragment
import br.com.sailboat.template.ui.main.drawer.SettingsFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 ->  HomeFragment()
            1 ->  SearchFragment()
            else -> SettingsFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Home"
            1 -> "Search"
            2 -> "Settings"
            else -> return super.getPageTitle(position)
        }

    }
}