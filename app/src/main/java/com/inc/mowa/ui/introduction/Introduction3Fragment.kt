package com.inc.mowa.ui.introduction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inc.mowa.databinding.FragmentIntroduction3Binding

class Introduction3Fragment : Fragment() {
    private lateinit var binding: FragmentIntroduction3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroduction3Binding.inflate(inflater, container, false)
        return binding.root
    }
}