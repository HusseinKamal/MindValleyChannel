package com.hussein.mindvalleychannel

import android.app.Application
import com.hussein.mindvalleychannel.dagger.ApplicationComponent
import com.hussein.mindvalleychannel.dagger.DaggerApplicationComponent

/**This APP Class for Dagger Component factory to handle dependency injection for retrofit and RoomDB etc**/
class App :Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component= DaggerApplicationComponent.factory().create(this)
    }
}