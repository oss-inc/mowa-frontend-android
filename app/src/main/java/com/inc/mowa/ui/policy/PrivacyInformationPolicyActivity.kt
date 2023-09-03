package com.inc.mowa.ui.policy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inc.mowa.R
import com.inc.mowa.databinding.ActivityPrivacyInformationPolicyBinding

class PrivacyInformationPolicyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrivacyInformationPolicyBinding
    private lateinit var policyRVAdapter: PrivacyInformationPolicyRVAdapter

    private var policies: ArrayList<PrivacyInformationPolicy> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyInformationPolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initRecyclerView()
        initClickListener()
    }

    /**
     * Initialize and setup privacy information policy contents
     *
     * @author seonwoo
     */
    private fun initData() {
        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_a_title),
                this.resources.getString(R.string.policy_privacy_information_a_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_b_title),
                this.resources.getString(R.string.policy_privacy_information_b_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_c_title),
                this.resources.getString(R.string.policy_privacy_information_c_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_d_title),
                this.resources.getString(R.string.policy_privacy_information_d_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_e_title),
                this.resources.getString(R.string.policy_privacy_information_e_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_f_title),
                this.resources.getString(R.string.policy_privacy_information_f_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_g_title),
                this.resources.getString(R.string.policy_privacy_information_g_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_h_title),
                this.resources.getString(R.string.policy_privacy_information_h_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_i_title),
                this.resources.getString(R.string.policy_privacy_information_i_description)
            )
        )

        policies.add(
            PrivacyInformationPolicy(
                this.resources.getString(R.string.policy_privacy_information_j_title),
                this.resources.getString(R.string.policy_privacy_information_j_description)
            )
        )
    }

    /**
     * Initialize RecyclerView
     *
     * @author seonwoo
     */
    private fun initRecyclerView() {
        policyRVAdapter = PrivacyInformationPolicyRVAdapter(policies)
        binding.privacyInformationPolicyRv.adapter = policyRVAdapter
    }

    /**
     * Initialize click listener
     *
     * @author seonwoo
     */
    private fun initClickListener() {

        // click close button
        binding.privacyInformationPolicyExitBtnIv.setOnClickListener {
            finish()
        }
    }
}