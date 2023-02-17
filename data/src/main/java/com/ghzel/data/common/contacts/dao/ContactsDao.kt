package com.ghzel.data.common.contacts.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ghzel.domain.contacts.dto.ContactModel
import kotlinx.coroutines.flow.Flow



@Dao
interface ContactsDao {
    @Query("select  *  from contacts where  name  LIKE '%' || :search || '%' or  number  LIKE '%' || :search || '%'  GROUP BY number order by name asc ")
    fun getAllContacts(search : String ): Flow<List<ContactModel>>

    @Query("delete from contacts ")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(contact : ContactModel)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertlist(contacts : List<ContactModel> )


}