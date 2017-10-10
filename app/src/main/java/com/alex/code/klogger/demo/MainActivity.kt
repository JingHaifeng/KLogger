package com.alex.code.klogger.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alex.code.library.AndroidLogAdapter
import com.alex.code.library.KLogger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello.text = "No body"
        KLogger.t("Main")
        KLogger.addLogAdapter(AndroidLogAdapter())
        KLogger.d("Message")
    }
}
