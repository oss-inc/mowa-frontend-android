package com.inc.mowa.ui.main.phonebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inc.mowa.databinding.FragmentPhonebookWelfarecenterBinding

class PhoneBookWelfareCenterFragment : Fragment() {
    private lateinit var binding: FragmentPhonebookWelfarecenterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonebookWelfarecenterBinding.inflate(inflater, container, false)
        return binding.root
    }
}