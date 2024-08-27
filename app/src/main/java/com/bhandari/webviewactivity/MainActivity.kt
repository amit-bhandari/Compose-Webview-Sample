package com.bhandari.webviewactivity

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.bhandari.webviewactivity.ui.theme.WebviewActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebviewActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WebViewComponent()
                }
            }
        }
    }
}

@Composable
fun WebViewComponent() {
    val context = LocalContext.current

    // AndroidView allows us to embed traditional Android views in Compose
    AndroidView(
        factory = {
            WebView(context).apply {
                // Configure WebView settings
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient() // Handle navigation within the WebView
                loadUrl("https://www.github.com") // Load your URL here
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WebviewActivityTheme {
        WebViewComponent()
    }
}