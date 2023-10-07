package com.example.panzoom

import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var pageView: DrawingView? = null

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup custom ImageView class that captures strokes
        // and draws them over the background image
        pageView = DrawingView(this)
        pageView!!.setMinimumWidth(1000)
        pageView!!.setMinimumHeight(2000)

        // setup background
        val image = BitmapFactory.decodeResource(resources, R.drawable.paper)
        pageView!!.setImage(image)

        // add to layout
        val layout = findViewById<LinearLayout>(R.id.layout)
        layout.addView(pageView)
        layout.isEnabled = true
    }
}