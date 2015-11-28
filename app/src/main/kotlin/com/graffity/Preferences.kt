package com.graffity

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by andrew on 11/28/15.
 */
public open class Preferences(prefs: SharedPreferences): SharedPreferences by prefs {
    val editor: SharedPreferences.Editor by lazy { edit() }

    constructor(context: Context) : this(prefs = PreferenceManager.getDefaultSharedPreferences(context)) {
    }

    public inner class IntPreference: ReadWriteProperty<SharedPreferences, Int> {
        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): Int {
            return thisRef.getInt(property.name, 0)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: Int) {
            editor.putInt(property.name, value)
        }
    }

    public inner class StringPreference: ReadWriteProperty<SharedPreferences, String> {
        override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): String {
            return thisRef.getString(property.name, null)
        }

        override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: String) {
            editor.putString(property.name, value)
        }
    }

    /*
    fun edit(func: Any?.() -> Unit) {
        func()
        editor.apply()
    }
    */
}