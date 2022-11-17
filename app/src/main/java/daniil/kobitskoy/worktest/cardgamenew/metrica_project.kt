package daniil.kobitskoy.worktest.cardgamenew

import android.app.Application
import com.onesignal.OneSignal

class metrica_project : Application() {
    override fun onCreate() {
        super.onCreate()
        try {


            // Enable verbose OneSignal logging to debug issues if needed.
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

            // OneSignal Initialization
            OneSignal.initWithContext(this)
            OneSignal.setAppId(parametrs_main.ONESIGNAL_KEY)
        } catch (e: Exception) {
        }
    }
}
