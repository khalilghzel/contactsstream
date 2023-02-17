package com.ghzel.contactstream.common

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class ContactsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //initialisation du stethou pour consulter le contenu du base du données en utilisant chromium
        Stetho.initializeWithDefaults(this)

    }

}