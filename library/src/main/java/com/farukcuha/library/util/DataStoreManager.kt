package com.farukcuha.library.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

abstract class DataStoreManager<T : Any>(
    private val context: Context,
    private val dataStore: DataStore<Preferences>
) {
    abstract val preferencesKey: Preferences.Key<T>

    val getData: Flow<T?> = dataStore.data.map { preferences ->
        preferences[preferencesKey]
    }

    suspend fun save(token: T) {
        dataStore.edit { preferences ->
            preferences[preferencesKey] = token
        }
    }

    suspend fun clear() {
        dataStore.edit {
            it.remove(preferencesKey)
        }
    }
}