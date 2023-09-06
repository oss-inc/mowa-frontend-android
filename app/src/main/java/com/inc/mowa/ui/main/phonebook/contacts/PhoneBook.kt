package com.inc.mowa.ui.main.phonebook.contacts

import com.google.gson.annotations.SerializedName

data class PhoneBook(
    @SerializedName("name") val name: String,
    @SerializedName("phone_number") val phoneNumber: String,
)