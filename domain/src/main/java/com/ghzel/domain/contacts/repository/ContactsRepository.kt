package com.ghzel.domain.contacts.repository

import com.ghzel.domain.contacts.dto.ContactModel
import kotlinx.coroutines.flow.Flow

interface ContactsRepository {
    suspend fun upsert(contact: ContactModel)
    suspend fun upsertList(contacts: List<ContactModel>)
    suspend fun getAllContacts(query : String): Flow<List<ContactModel>>
    suspend fun syncData()
}