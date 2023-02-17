package com.ghzel.domain.contacts.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(
    tableName = "contacts"
)
data class ContactModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val name: String ,
    val number: String
) : Serializable {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            name,
            number,
            "${name.first()} ${number.first()}",
            "${name} ${number}",
            "${number} ${name}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
