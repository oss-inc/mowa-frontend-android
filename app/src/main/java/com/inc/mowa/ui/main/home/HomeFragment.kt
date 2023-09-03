package com.inc.mowa.ui.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.inc.mowa.databinding.FragmentHomeBinding
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_LOCATION
import com.inc.mowa.viewmodel.LocationViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val locationViewModel: LocationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationViewModel.currentLocation.observe(viewLifecycleOwner) { location ->
            // update ui whenever the location value is changed
            if (location != null) {
                Log.d(LOG_LOCATION, "location: (${location.latitude}, ${location.longitude})")
            }
        }
    }
}