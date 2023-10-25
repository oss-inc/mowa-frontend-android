package com.inc.mowa.ui.main.phonebook.welfarecenter

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.inc.mowa.R
import com.inc.mowa.data.welfarecenter.WelfareCenter
import com.inc.mowa.data.welfarecenter.WelfareCenterService
import com.inc.mowa.data.welfarecenter.WelfareCenterView
import com.inc.mowa.databinding.FragmentPhonebookWelfarecenterBinding
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_API
import com.inc.mowa.utils.ApplicationClass.Companion.LOG_LOCATION
import com.inc.mowa.utils.ApplicationClass.Companion.showToast
import com.inc.mowa.utils.getLatitude
import com.inc.mowa.utils.getLongitude
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.util.Locale

class PhoneBookWelfareCenterFragment : Fragment(), WelfareCenterView {
    private lateinit var binding: FragmentPhonebookWelfarecenterBinding
    private lateinit var welfareCenterRVAdapter: PhoneBookWelfareCenterRVAdapter

    private var welfareCenterService: WelfareCenterService = WelfareCenterService()
    private var welfareCenters = ArrayList<WelfareCenter>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonebookWelfarecenterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        initWelfareCenterService()
    }

    private fun initRecyclerView() {
        welfareCenterRVAdapter = PhoneBookWelfareCenterRVAdapter(object :
            PhoneBookWelfareCenterRVAdapter.ItemClickListener {
            override fun onItemClick(view: View, itemPosition: Int) {
                showCallDialog(itemPosition)
            }
        })

        binding.phonebookWelfarecenterRv.adapter = welfareCenterRVAdapter
    }

    private fun initWelfareCenterService() {
        val latitude = getLatitude()
        val longitude = getLongitude()

        GlobalScope.launch(Dispatchers.IO) {
            val geocoder = Geocoder(requireContext(), Locale.getDefault())
            var region: String? = null

            if (Build.VERSION.SDK_INT < 33) {
                val addresses = geocoder.getFromLocation(latitude, longitude, 1)

                if (addresses!!.isNotEmpty()) {
                    val address = addresses[0]
                    Log.d(LOG_API, "(initWelfareCenterService) addresses: $addresses")
                    region = address.locality
                }

            } else {
                geocoder.getFromLocation(latitude, longitude, 1, object : Geocoder.GeocodeListener {
                    override fun onGeocode(addresses: MutableList<Address>) {
                        val address = addresses[0]
                        Log.d(LOG_API, "(initWelfareCenterService) address: $address")
                        region = address.locality
                    }

                    override fun onError(errorMessage: String?) {
                        showToast(requireContext(), "주소가 발견되지 않았습니다.")
                    }
                })
            }

            withContext(Dispatchers.Main) {
                if (region != null) {
                    welfareCenterService.getWelfareCenters(
                        this@PhoneBookWelfareCenterFragment,
                        region
                    )
                } else {
                    showToast(requireContext(), "주소가 발견되지 않았습니다.")
                }
            }
        }
    }

    private fun showCallDialog(position: Int) {
        AlertDialog.Builder(requireContext(), R.style.dialog).setTitle("전화 걸기")
            .setMessage("해당 번호로 전화를 거시겠습니까?").setIcon(R.drawable.ic_mowa_not_title)
            .setPositiveButton("예") { _, _ ->
                val intent = Intent(
                    Intent.ACTION_DIAL, Uri.parse("tel:" + welfareCenters[position].telephoneNumber)
                )
                startActivity(intent)
            }.setNegativeButton("아니오") { dialog, _ ->
                dialog.dismiss()
            }.create().show()
    }

    private fun initMap() {
        val mapView = MapView(context)
        binding.phonebookWelfarecenterMapContainerRl.addView(mapView)

        mapView.apply {
            setZoomLevel(4, true)
        }

        mapView.currentLocationTrackingMode =
            MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading

        val markers = ArrayList<MapPOIItem>()

        for (welfareCenter in welfareCenters) {
            val marker = MapPOIItem()

            val latitude = if (welfareCenter.latitude == null) 0.0 else welfareCenter.latitude
            val longitude = if (welfareCenter.longitude == null) 0.0 else welfareCenter.longitude

            marker.mapPoint = MapPoint.mapPointWithGeoCoord(
                latitude!!,
                longitude!!
            )
            marker.itemName = welfareCenter.name
            markers.add(marker)
        }

        mapView.addPOIItems(markers.toArray(arrayOfNulls(markers.size)))
    }

    override fun onGetWelfareCenterSuccess(welfareCenters: List<WelfareCenter>) {
        Log.d(
            LOG_API, "(onGetWelfareCenterSuccess) Success to get welfare centers: $welfareCenters"
        )
        welfareCenterRVAdapter.addData(welfareCenters as ArrayList)

        this.welfareCenters.clear()
        this.welfareCenters.addAll(welfareCenters)

        initMap()
    }

    override fun onGetWelfareCenterFailure(code: Int, message: String) {
        Log.d(LOG_API, "(onGetWelfareCenterFailure) Fail to get welfare center: $code, $message")
        showToast(requireContext(), "복지 시설을 불러오는 데 실패했습니다.")
    }
}
