package com.inc.mowa.ui.introduction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inc.mowa.databinding.FragmentIntroduction1Binding

class Introduction1Fragment : Fragment() {
    private lateinit var binding: FragmentIntroduction1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroduction1Binding.inflate(inflater, container, false)
        return binding.root
    }
}