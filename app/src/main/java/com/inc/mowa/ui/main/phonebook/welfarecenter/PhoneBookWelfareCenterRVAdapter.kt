package com.inc.mowa.ui.main.phonebook.welfarecenter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inc.mowa.data.welfarecenter.WelfareCenter
import com.inc.mowa.databinding.ItemPhonebookWelfarecenterBinding

class PhoneBookWelfareCenterRVAdapter(
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<PhoneBookWelfareCenterRVAdapter.ViewHolder>() {

    private var welfareCenters = ArrayList<WelfareCenter>()

    interface ItemClickListener {
        fun onItemClick(view: View, itemPosition: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPhonebookWelfarecenterBinding =
            ItemPhonebookWelfarecenterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(welfareCenters[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(holder.itemView, position)
        }
    }

    override fun getItemCount(): Int {
        return welfareCenters.size
    }

    inner class ViewHolder(val binding: ItemPhonebookWelfarecenterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(welfareCenter: WelfareCenter) {
            binding.itemPhonebookWelfarecenterNameTv.text = welfareCenter.name
            binding.itemPhonebookWelfarecenterNumberTv.text = welfareCenter.telephoneNumber
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(welfareCenters: ArrayList<WelfareCenter>) {
        this.welfareCenters.clear()
        this.welfareCenters = welfareCenters
        notifyDataSetChanged()
    }
}