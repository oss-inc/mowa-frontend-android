package com.inc.mowa.ui.introduction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inc.mowa.databinding.FragmentIntroduction2Binding

class Introduction2Fragment : Fragment() {
    private lateinit var binding: FragmentIntroduction2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroduction2Binding.inflate(inflater, container, false)
        return binding.root
    }
}