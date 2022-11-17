package daniil.kobitskoy.worktest.cardgamenew

import android.app.Application
import android.util.Log
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener
import java.util.*


class App: Application() {
     var response: MutableMap<String, Any>? = null

    fun returnAttribution(): MutableMap<String, Any>? {


        return response
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("ЕБАТЬ", "Копать")
        val conversionListener: AppsFlyerConversionListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(conversionDataMap: Map<String, Any>) {
                for (attrName in conversionDataMap.keys) Log.d(
                    "LOG_TAG",
                    "Conversion attribute: " + attrName + " = " + conversionDataMap[attrName]
                )
                val status: String =
                    Objects.requireNonNull(conversionDataMap["af_status"]).toString()
                if (status == "Organic") {
                    // Business logic for Organic conversion goes here.
                } else {
                    // Business logic for Non-organic conversion goes here.
                }
            }

            override fun onConversionDataFail(errorMessage: String) {
                Log.d(
                    "LOG_TAG",
                    "error getting conversion data: $errorMessage"
                )
            }

            override fun onAppOpenAttribution(attributionData: Map<String, String>) {
                // Must be overriden to satisfy the AppsFlyerConversionListener interface.
                // Business logic goes here when UDL is not implemented.
            }

            override fun onAttributionFailure(errorMessage: String) {
                // Must be overriden to satisfy the AppsFlyerConversionListener interface.
                // Business logic goes here when UDL is not implemented.
                Log.d("LOG_TAG", "error onAttributionFailure : $errorMessage")
            }
        }
        Log.d("get", "get")

        AppsFlyerLib.getInstance().init(parametrs_main.APPSFLYER_KEY, conversionListener, this)
        AppsFlyerLib.getInstance().setDebugLog(true)
        AppsFlyerLib.getInstance().start(this)
    }



}



