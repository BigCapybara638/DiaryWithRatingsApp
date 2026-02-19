package com.example.composetraining

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComposeTrainingApp : Application()
{
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}