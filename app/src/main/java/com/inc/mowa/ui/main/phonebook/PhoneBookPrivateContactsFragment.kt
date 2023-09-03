package com.inc.mowa.ui.main.phonebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inc.mowa.databinding.FragmentPhonebookPrivatecontactsBinding

class PhoneBookPrivateContactsFragment : Fragment() {
    private lateinit var binding: FragmentPhonebookPrivatecontactsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonebookPrivatecontactsBinding.inflate(inflater, container, false)
        return binding.root
    }
}