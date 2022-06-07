package com.capstone.surehealth.data.model

import android.content.Context

class UserPreferences(context: Context) {
    private val userPreferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    fun setUsers(value: User){
        val editor = userPreferences.edit()
        editor.putString(ID_USER, value.id_user)
        editor.apply()
    }

    fun getUsers(): User {
        val model = User()
        model.id_user = userPreferences.getString(ID_USER, "")
        return model
    }

    companion object {
        private const val USER_PREFERENCES = "user_preference"
        private const val ID_USER = "id_user"
    }
}