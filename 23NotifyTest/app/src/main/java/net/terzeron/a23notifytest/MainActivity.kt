package net.terzeron.a23notifytest

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private var notificationManager: NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel("notify.demo", "NotifyDemo News", "Example News Channel")
    }

    private fun createNotificationChannel(id: String, name: String, description: String) {
        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(id, name, importance)

        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationManager?.createNotificationChannel(channel)
    }

    fun sendNotification(view: View) {
        val resultIntent = Intent(this, ResultActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        val channelID = "notify.demo"
        val notification: Notification = Notification.Builder(this@MainActivity, channelID)
                .setContentTitle("Example notification")
                .setContentText("This is an example")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .build()
        val notificationID:Int = System.currentTimeMillis().toInt()
        notificationManager?.notify(notificationID, notification)
    }
}
