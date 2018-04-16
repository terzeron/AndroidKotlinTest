package net.terzeron.a20implicitintenttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_page.*
import java.net.URL

class WebPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_page)

        handleIntent()
    }

    private fun handleIntent() {
        val intent = this.intent
        val data = intent.data
        var url: URL? = null

        try {
            url = URL(data?.scheme, data?.host, data?.path)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        webView.loadUrl(url?.toString())
    }
}
