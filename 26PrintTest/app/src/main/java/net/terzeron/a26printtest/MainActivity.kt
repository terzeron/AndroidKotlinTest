package net.terzeron.a26printtest

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    private var myWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printWebView()
    }

    private fun createWebPrintJob(view: WebView) {
        var printManager = this.getSystemService(Context.PRINT_SERVICE) as PrintManager
        val printAdapter = view?.createPrintDocumentAdapter("MyDocument")
        val jobName = getString(R.string.app_name) + " Print Test"

        printManager.print(jobName, printAdapter, PrintAttributes.Builder().build())
    }

    private fun printWebView() {
        val webView = WebView(this)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                createWebPrintJob(view)
                myWebView = null
            }
        }

        val html = "<html><body><h1>Android Print Test</h1><p>This is some sample content.</p></body></html>";
        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)
        myWebView = webView
        
    }
}
