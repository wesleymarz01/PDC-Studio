package com.example.pdcstudio

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {

    private var uploadCallback: ValueCallback<Array<Uri>>? = null

    private val filePickerLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            val callback = uploadCallback

            if (callback != null) {

                val uris = if (result.resultCode == RESULT_OK) {

                    val data = result.data

                    when {
                        data?.clipData != null -> {
                            val clip = data.clipData!!

                            Array(clip.itemCount) { index ->
                                clip.getItemAt(index).uri
                            }
                        }

                        data?.data != null -> {
                            arrayOf(data.data!!)
                        }

                        else -> null
                    }

                } else {
                    null
                }

                callback.onReceiveValue(uris)
                uploadCallback = null
            }
        }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AndroidView(
                modifier = Modifier.fillMaxSize(),

                factory = { context ->

                    WebView(context).apply {

                        settings.javaScriptEnabled = true

                        settings.domStorageEnabled = true

                        settings.databaseEnabled = true

                        settings.allowFileAccess = true

                        settings.allowContentAccess = true

                        settings.javaScriptCanOpenWindowsAutomatically = true

                        webViewClient = WebViewClient()

                        webChromeClient = object : WebChromeClient() {

                            override fun onShowFileChooser(
                                webView: WebView?,
                                filePathCallback: ValueCallback<Array<Uri>>?,
                                fileChooserParams: FileChooserParams?
                            ): Boolean {

                                uploadCallback?.onReceiveValue(null)

                                uploadCallback = filePathCallback

                                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {

                                    addCategory(Intent.CATEGORY_OPENABLE)

                                    type = "*/*"

                                    putExtra(
                                        Intent.EXTRA_ALLOW_MULTIPLE,
                                        true
                                    )
                                }

                                return try {

                                    filePickerLauncher.launch(
                                        Intent.createChooser(
                                            intent,
                                            "Selecionar arquivos"
                                        )
                                    )

                                    true

                                } catch (e: Exception) {

                                    uploadCallback?.onReceiveValue(null)

                                    uploadCallback = null

                                    false
                                }
                            }
                        }

                        loadUrl("file:///android_asset/index.html")
                    }
                }
            )
        }
    }
}