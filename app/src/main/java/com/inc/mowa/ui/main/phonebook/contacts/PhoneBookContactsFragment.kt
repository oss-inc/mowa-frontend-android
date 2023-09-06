package com.inc.mowa.ui.main.phonebook.contacts

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.inc.mowa.R
import com.inc.mowa.databinding.FragmentPhonebookContactsBinding
import com.inc.mowa.utils.ApplicationClass.Companion.showToast

class PhoneBookContactsFragment : Fragment() {

    companion object {
        const val SORT_ORDER = ContactsContract.Data.MIMETYPE
    }

    private lateinit var binding: FragmentPhonebookContactsBinding
    private lateinit var cursor: Cursor
    private lateinit var phoneBookContactsRVAdapter: PhoneBookContactsRVAdapter

    private var contacts = ArrayList<PhoneBook>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonebookContactsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initPhoneBookContacts()
        initRecyclerView()
        initClickListener()
    }

    private fun initPhoneBookContacts() {

        if (contacts.size == 0) {

            cursor = requireContext().contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                SORT_ORDER
            )!!

            val displayNameColumnIndex =
                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            val phoneNumberColumnIndex =
                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

            while (cursor.moveToNext()) {
                val contactName =
                    cursor.getString(displayNameColumnIndex)
                var phoneNumber =
                    cursor.getString(phoneNumberColumnIndex)

                val match = "[^0-9]"
                phoneNumber = phoneNumber.replace(match, "")

                contacts.add(PhoneBook(contactName, phoneNumber))
            }

            cursor.close()
        }
    }

    private fun initRecyclerView() {

        phoneBookContactsRVAdapter = PhoneBookContactsRVAdapter(
            object : PhoneBookContactsRVAdapter.ItemClickListener {
                override fun onItemClick(view: View, itemPosition: Int) {
                    showCallDialog(itemPosition)
                }
            })

        binding.phonebookContactsRv.adapter = phoneBookContactsRVAdapter
        phoneBookContactsRVAdapter.addData(contacts)
    }

    private fun initClickListener() {
        binding.phonebookContactsUpdateIv.setOnClickListener {
            showToast(requireContext(), "전화번호부를 업데이트합니다.")
            initPhoneBookContacts()
        }
    }

    private fun showCallDialog(position: Int) {
        AlertDialog.Builder(requireContext(), R.style.dialog)
            .setTitle("전화 걸기")
            .setMessage("해당 번호로 전화를 거시겠습니까?")
            .setIcon(R.drawable.ic_mowa_not_title)
            .setPositiveButton("예") { _, _ ->
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + contacts[position].phoneNumber)
                )
                startActivity(intent)
            }
            .setNegativeButton("아니오") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}