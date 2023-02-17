package com.ghzel.data.common.contacts.repository


import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.provider.ContactsContract
import android.util.Log
import com.ghzel.data.common.contacts.dao.ContactsDao
import com.ghzel.domain.contacts.dto.ContactModel
import com.ghzel.domain.contacts.repository.ContactsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ExperimentalCoroutinesApi
class ContactsRepositoryImpl @Inject constructor(
    private val dao: ContactsDao,
    private val context: Context
) : ContactsRepository {

    override suspend fun upsert(contact: ContactModel) {
        dao.upsert(contact)
    }

    override suspend fun upsertList(contacts: List<ContactModel>) {
        dao.deleteAll()
        dao.upsertlist(contacts)
    }
    override suspend fun getAllContacts(query : String): Flow<List<ContactModel>> {
        return dao.getAllContacts(query)
    }

    @SuppressLint("Range")
    override suspend fun syncData() {
        val phoneContacts: MutableList<ContactModel> = mutableListOf()
        dao.deleteAll()
        val phones = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        while (phones!!.moveToNext()) {
            val name =
                phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val phoneNumber =
                phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
            val contactModel = ContactModel(null, name, phoneNumber)
            phoneContacts.add(contactModel)
        }
        dao.upsertlist(phoneContacts)
        phones.close()
    }
}