package com.ghzel.domain.contacts.usecases


import com.ghzel.domain.contacts.dto.ContactModel
import com.ghzel.domain.contacts.repository.ContactsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllContactsUseCase @Inject constructor(private val contactsRepository: ContactsRepository) {
    suspend fun invoke(query : String): Flow<List<ContactModel>> {
        return contactsRepository.getAllContacts(query)
    }
}