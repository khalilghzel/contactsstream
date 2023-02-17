package com.ghzel.domain.contacts.usecases

data class ContactsUseCase(
    val getAllContactsUseCase: GetAllContactsUseCase,
    val upsertContactUseCase: UpsertContactUseCase,
    val upsertListContactUseCase: UpsertListContactUseCase,
    val syncContactUseCase: SyncContactUseCase
)