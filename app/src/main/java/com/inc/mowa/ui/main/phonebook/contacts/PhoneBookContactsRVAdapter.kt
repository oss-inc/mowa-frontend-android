package com.inc.mowa.ui.main.phonebook.contacts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inc.mowa.databinding.ItemPhonebookContactsBinding

class PhoneBookContactsRVAdapter(
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<PhoneBookContactsRVAdapter.ViewHolder>() {

    private var contacts = ArrayList<PhoneBook>()

    interface ItemClickListener {
        fun onItemClick(view: View, itemPosition: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhoneBookContactsRVAdapter.ViewHolder {
        val binding: ItemPhonebookContactsBinding =
            ItemPhonebookContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneBookContactsRVAdapter.ViewHolder, position: Int) {
        holder.bind(contacts[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(holder.itemView, position)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(val binding: ItemPhonebookContactsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(phoneBook: PhoneBook) {
            binding.itemPhonebookContactsNameTv.text = phoneBook.name
            binding.itemPhonebookContactsNumberTv.text = phoneBook.phoneNumber
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(contacts: List<PhoneBook>) {
        this.contacts.clear()
        this.contacts.addAll(contacts as ArrayList)
        notifyDataSetChanged()
    }
}