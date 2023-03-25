package com.example.cloudanalytics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cloude1.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = FirebaseAnalytics.getInstance(this)
        button.setOnClickListener {
            selectEvent("image1", "imageView", "image")
        }
        button2.setOnClickListener {
            secreenEventP()
        }
    }

    fun selectEvent(id: String, name: String, contentType: String) {
        val params = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, id)
            putString(FirebaseAnalytics.Param.ITEM_NAME, name)
            putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
        }
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, params)
    }

    fun secreenEventP() {
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, "main")
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        }
    }
}

/*
class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        analytics = Firebase.analytics
    }

    fun selectEvent(id: String, name: String, contentType: String) {

        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(FirebaseAnalytics.Param.ITEM_ID.id)
            param(FirebaseAnalytics.Param.ITEM_NAME.name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE.contentType)
        }



        }
    }
* */
