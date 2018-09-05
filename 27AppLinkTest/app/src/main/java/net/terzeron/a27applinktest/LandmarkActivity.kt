package net.terzeron.a27applinktest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_landmark.*


class LandmarkActivity : AppCompatActivity() {
    private var dbHandler: MyDBHandler? = null
    private var landmark: Landmark? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark)

        dbHandler = MyDBHandler(this, null, null, 1)

        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data

        if (appLinkAction != null) {
            if (appLinkAction == "android.intent.action.VIEW") {
                val landmarkId = appLinkData?.lastPathSegment
                if (landmarkId != null) {
                    displayLandmark(landmarkId)
                }
            }
        } else {
            handleIntent(intent)
        }
    }

    private fun handleIntent(intent: Intent) {
        val landmarkId = intent.getStringExtra(MainActivity.LANDMARK_ID)
        displayLandmark(landmarkId)
    }

    private fun displayLandmark(landmarkId: String) {
        landmark = dbHandler?.findLandmark(landmarkId)
        if (landmark != null) {
            titleText?.text = landmark?.title
            descriptionText?.text = landmark?.description
            deleteButton?.isEnabled = landmark?.personal == 1
        } else {
            titleText?.text = "No Match Found"
        }
    }

    fun deleteLandmark(view: View) {
        if (landmark != null) {
            dbHandler?.deleteLandmark(landmark?.id)
            titleText?.text = ""
            descriptionText?.text = ""
            deleteButton?.isEnabled = false
        }
    }
}
