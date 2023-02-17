package com.ghzel.domain.contacts.usecases


import com.ghzel.domain.contacts.repository.ContactsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SyncContactUseCase @Inject constructor(private val contactRepository: ContactsRepository) {
    suspend fun invoke() {
        return contactRepository.syncData()
    }
}