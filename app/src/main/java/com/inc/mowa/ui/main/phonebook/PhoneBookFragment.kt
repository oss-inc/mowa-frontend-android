package com.inc.mowa.ui.main.phonebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.inc.mowa.databinding.FragmentPhonebookBinding

class PhoneBookFragment : Fragment() {
    private lateinit var binding: FragmentPhonebookBinding
    private lateinit var phoneBookVPAdapter: PhoneBookVPAdapter

    private val tabMenu: ArrayList<String> = arrayListOf("복지 시설", "전화번호부")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonebookBinding.inflate(inflater, container, false)
        binding.phonebookVp.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initViewPager()
    }

    private fun initViewPager() {
        phoneBookVPAdapter = PhoneBookVPAdapter(this)
        binding.phonebookVp.adapter = phoneBookVPAdapter

        TabLayoutMediator(binding.phonebookTl, binding.phonebookVp) { tab, position ->
            tab.text = tabMenu[position]
        }.attach()
    }
}