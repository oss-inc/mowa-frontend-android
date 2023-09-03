package com.inc.mowa.ui.introduction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.inc.mowa.databinding.FragmentIntroductionBinding

class IntroductionFragment : Fragment() {
    private lateinit var binding: FragmentIntroductionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroductionBinding.inflate(inflater, container, false)
        initViewPager()
        return binding.root
    }

    /**
     * Initialize ViewPager
     *
     * @author seonwoo
     */
    private fun initViewPager() {
        val introductionVPAdapter: IntroductionVPAdapter =
            IntroductionVPAdapter(this@IntroductionFragment)

        // add fragments containing application introduction contents
        introductionVPAdapter.addFragment(Introduction1Fragment())
        introductionVPAdapter.addFragment(Introduction2Fragment())
        introductionVPAdapter.addFragment(Introduction3Fragment())

        binding.introductionVp.adapter = introductionVPAdapter
        binding.introductionVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.introductionIndicator.attachTo(binding.introductionVp)

        // remove the shadow of scroll
        binding.introductionVp.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }
}