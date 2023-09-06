package com.inc.mowa.ui.main.phonebook

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.inc.mowa.ui.main.phonebook.contacts.PhoneBookContactsFragment
import com.inc.mowa.ui.main.phonebook.welfarecenter.PhoneBookWelfareCenterFragment

class PhoneBookVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PhoneBookWelfareCenterFragment()
            else -> PhoneBookContactsFragment()
        }
    }
}