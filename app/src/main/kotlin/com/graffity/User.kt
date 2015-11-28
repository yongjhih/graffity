package com.graffity

import android.content.Context

/**
 * Created by andrew on 11/28/15.
 */
public class User(context: Context) : Preferences(context) {
    var name: String by StringPreference()
    var age: Int by IntPreference()

    fun edit(func: User.() -> Unit) {
        func()
        editor.apply()
    }
}
