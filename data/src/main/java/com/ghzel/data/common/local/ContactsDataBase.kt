package com.ghzel.data.common.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ghzel.data.common.contacts.dao.ContactsDao
import com.ghzel.domain.contacts.dto.ContactModel


@Database(
    entities = [ContactModel::class],
    version = 1

)
abstract class ContactsDataBase : RoomDatabase() {
   abstract fun getContactDao(): ContactsDao

    companion object {
        @Volatile
        private var instance: ContactsDataBase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDataBase(context).also { instance = it }
        }
        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ContactsDataBase::class.java,
                "contacts_db.db"
            ).fallbackToDestructiveMigration().build()
    }
 }




