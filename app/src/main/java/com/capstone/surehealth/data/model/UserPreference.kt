package com.capstone.surehealth.data.model

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreference private constructor(private val dataStore: DataStore<Preferences>){

    suspend fun saveidToken(user: User) {
        dataStore.edit { preferences ->

            preferences[ID_KEY] = user.id_user
            preferences[STATE_KEY] = user.state

        }
    }

    val idtoken : Flow<User> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("error", exception.message.toString())
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }.map {
            val userid = it[ID_KEY] ?: ""
            val state = it[STATE_KEY] ?: false
            User( id_user = userid,state = state)
        }

    suspend fun logout() {
        dataStore.edit {
            it.clear()
        }
    }


    companion object{
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val ID_KEY = stringPreferencesKey("id_user")
        private val STATE_KEY = booleanPreferencesKey("error")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}