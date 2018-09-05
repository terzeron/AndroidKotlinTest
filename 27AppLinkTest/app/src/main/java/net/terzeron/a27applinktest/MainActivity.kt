package net.terzeron.a27applinktest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var dbHandler: MyDBHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = MyDBHandler(this, null, null, 1)
    }

    companion object {
        val LANDMARK_ID = "landmarkID"
    }

    fun findLandmark(view: View) {
        if (idText?.text.toString() != "") {
            val landmark = dbHandler?.findLandmark(idText?.text.toString())

            if (landmark != null) {
                val intent = Intent(this, LandmarkActivity::class.java)
                val landmarkid = idText?.text.toString()
                intent.putExtra(LANDMARK_ID, landmarkid)
                startActivity(intent)
            } else {
                titleText?.setText("No Match")
            }
        }
    }

    fun addLandmark(view: View) {
        val landmark = Landmark(idText?.text.toString(), titleText?.text.toString(), descriptionText?.text.toString(), 1)

        dbHandler?.addLandmark(landmark)
        idText?.setText("")
        titleText?.setText("")
        descriptionText.setText("")
    }
}
