package com.inc.mowa.ui.introduction

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class IntroductionVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments: ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    /**
     * Add fragment for showing on ViewPager
     *
     * @author seonwoo
     */
    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)

        // notify the index of inserted fragments to ViewPager
        notifyItemInserted(fragments.size - 1)
    }
}