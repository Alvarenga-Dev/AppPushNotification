package com.alvarengadev.apppushnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alvarengadev.apppushnotification.utils.PushNotificationApp
import java.util.*

class MainActivity : AppCompatActivity() {

    private val context = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn_notify)
        val pushNotificationApp = PushNotificationApp(context)

        button.setOnClickListener {
            pushNotificationApp.builder(
                    Random().nextInt(),
                    "Hello World",
                "My first push notification!"
            )
        }

    }
}