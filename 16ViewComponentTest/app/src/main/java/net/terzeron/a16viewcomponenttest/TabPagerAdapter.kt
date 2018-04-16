package net.terzeron.a16viewcomponenttest

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


/**
 * Created by terzeron on 2018. 3. 26..
 */
class TabPagerAdapter(fm: FragmentManager, private var tabCount: Int): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return Tab1Fragment()
            1 -> return Tab2Fragment()
            2 -> return Tab3Fragment()
            3 -> return Tab4Fragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}