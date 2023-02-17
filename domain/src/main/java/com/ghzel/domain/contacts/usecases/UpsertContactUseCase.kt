package com.ghzel.domain.contacts.usecases

import com.ghzel.domain.contacts.dto.ContactModel
import com.ghzel.domain.contacts.repository.ContactsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpsertContactUseCase @Inject constructor(private val contactsRepository: ContactsRepository) {
    suspend fun invoke( contact  : ContactModel){
        return contactsRepository.upsert(contact)
    }
}