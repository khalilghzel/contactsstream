package com.ghzel.data.common.local

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserData @Inject constructor(val context: Application) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES_NAME)
    suspend fun updateNightMode(nightMode: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[NIGHTMODE] = nightMode
        }
    }

    val nightMode: Flow<Boolean>
        get() = context.dataStore.data.map { preferences ->
            preferences[NIGHTMODE] ?: false
        }

    companion object {
        const val USER_PREFERENCES_NAME = "USER_PREFERENCES_NAME"
        val NIGHTMODE = booleanPreferencesKey("NIGHTMODE")
    }
}