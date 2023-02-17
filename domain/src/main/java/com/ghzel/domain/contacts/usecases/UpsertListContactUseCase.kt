package com.ghzel.domain.contacts.usecases


import com.ghzel.domain.contacts.repository.ContactsRepository
import com.ghzel.domain.contacts.dto.ContactModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpsertListContactUseCase @Inject constructor(private val contactRepository: ContactsRepository) {
    suspend fun invoke(contacts: List<ContactModel>) {
        return contactRepository.upsertList(contacts)
    }
}