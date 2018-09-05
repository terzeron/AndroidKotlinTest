package net.terzeron.a29mediaplaybacktest

import android.Manifest
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val REQUEST_PERMISSION_CODE = 101
    private var audioFilePath: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var isRecording = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioSetup()
    }

    private fun audioSetup() {
        playButton.isEnabled = false
        stopButton.isEnabled = false
        audioFilePath = Environment.getExternalStorageDirectory().absolutePath + "/myaudio.3gp"

        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_PERMISSION_CODE)
    }

    fun recordAudio(view: View) {
        isRecording = true
        stopButton.isEnabled = true
        playButton.isEnabled = false
        recordButton.isEnabled = false

        try {
            mediaRecorder = MediaRecorder()
            mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
            mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            mediaRecorder?.setOutputFile(audioFilePath)
            mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            mediaRecorder?.prepare()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mediaRecorder?.start()
    }

    fun stopAudio(view: View) {
        stopButton.isEnabled = false
        playButton.isEnabled = true

        if (isRecording) {
            recordButton.isEnabled = false
            mediaRecorder?.stop()
            mediaRecorder?.release()
            mediaRecorder = null
            isRecording = false
        } else {
            mediaPlayer?.release()
            mediaPlayer = null
            recordButton.isEnabled = true
        }
    }

    fun playAudio(view: View) {
        playButton.isEnabled = false
        recordButton.isEnabled = false
        stopButton.isEnabled = true
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(audioFilePath)
        mediaPlayer?.prepare()
        mediaPlayer?.start()
    }
}
