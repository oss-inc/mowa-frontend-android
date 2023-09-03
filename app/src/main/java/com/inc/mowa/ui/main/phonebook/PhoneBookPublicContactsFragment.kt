package com.inc.mowa.ui.main.phonebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inc.mowa.databinding.FragmentPhonebookPubliccontactsBinding

class PhoneBookPublicContactsFragment : Fragment() {
    private lateinit var binding: FragmentPhonebookPubliccontactsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonebookPubliccontactsBinding.inflate(inflater, container, false)
        return binding.root
    }
}