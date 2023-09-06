package com.inc.mowa.ui.policy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inc.mowa.databinding.ItemPrivacyInformationPolicyBinding

class PrivacyInformationPolicyRVAdapter(private val polices: ArrayList<PrivacyInformationPolicy>) :
    RecyclerView.Adapter<PrivacyInformationPolicyRVAdapter.ViewHolder>() {
    private lateinit var binding: ItemPrivacyInformationPolicyBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PrivacyInformationPolicyRVAdapter.ViewHolder {
        binding = ItemPrivacyInformationPolicyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PrivacyInformationPolicyRVAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(polices[position])
        binding = holder.binding
    }

    override fun getItemCount(): Int {
        return polices.size
    }

    /**
     * Custom ViewHolder to bind data class to layout
     *
     * @author seonwoo
     */
    inner class ViewHolder(val binding: ItemPrivacyInformationPolicyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(privacyInformationPolicy: PrivacyInformationPolicy) {

            if (binding.itemPrivacyInformationPolicyTitleTv.equals(" ") || binding.itemPrivacyInformationPolicyTitleTv.equals("")) {
                binding.itemPrivacyInformationPolicyTitleTv.visibility = View.GONE
            } else {
                binding.itemPrivacyInformationPolicyTitleTv.text = privacyInformationPolicy.title
            }

            binding.itemPrivacyInformationPolicyContentTv.text = privacyInformationPolicy.content
        }
    }
}