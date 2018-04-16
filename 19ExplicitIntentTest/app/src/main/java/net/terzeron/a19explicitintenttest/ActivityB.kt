package net.terzeron.a19explicitintenttest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val extras = intent.extras ?: return
        val qString = extras.getString("qString")
        textViewB.text = qString
    }

     fun onClick(view: View) {
         finish()
     }

    override fun finish() {
        val data = Intent()

        val returnString = editTextB.text.toString()
        data.putExtra("returnData", returnString)

        setResult(RESULT_OK, data)
        super.finish()
    }
}
