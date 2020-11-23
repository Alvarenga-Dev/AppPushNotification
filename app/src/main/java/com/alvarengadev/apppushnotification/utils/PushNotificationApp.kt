package com.alvarengadev.apppushnotification.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.alvarengadev.apppushnotification.R

class PushNotificationApp(private val context: Context) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun builder(notificationId: Int, title: String, message: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                    Constants.ID_CHANNEL,
                    Constants.NOTIFICATION_HELLO_WORLD,
                    NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val createNotification = NotificationCompat.Builder(context, Constants.ID_CHANNEL)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(NotificationCompat
                        .BigTextStyle()
                        .bigText("My first push notification, Lorem Lorem Lorem Lorem Lorem Lorem")
                )
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        notificationManager.notify(notificationId, createNotification.build())
    }

}