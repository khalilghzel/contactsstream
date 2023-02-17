package com.ghzel.data.common.local

import android.content.Context
import com.ghzel.data.common.contacts.dao.ContactsDao
import com.ghzel.data.common.contacts.repository.ContactsRepositoryImpl
import com.ghzel.domain.contacts.repository.ContactsRepository
import com.ghzel.domain.contacts.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Singleton
    @Provides
    fun providecontactsDao(@ApplicationContext appContext: Context): ContactsDao {
        return ContactsDataBase(appContext).getContactDao()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Singleton
    @Provides
    fun provideCategoriesRepository(
        categoriesDao: ContactsDao,
        @ApplicationContext appContext: Context
    ): ContactsRepository {
        return ContactsRepositoryImpl(categoriesDao, appContext)
    }

    @Singleton
    @Provides
    fun provideUseCases(repository: ContactsRepository) = ContactsUseCase(
        getAllContactsUseCase = GetAllContactsUseCase(repository),
        upsertContactUseCase = UpsertContactUseCase(repository),
        upsertListContactUseCase = UpsertListContactUseCase(repository),
        syncContactUseCase = SyncContactUseCase(repository)
    )
}
