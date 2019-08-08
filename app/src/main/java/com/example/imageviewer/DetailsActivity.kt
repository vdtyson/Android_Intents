package com.example.imageviewer

import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageviewer.MainActivity.Companion.IMAGE_NAME
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private val images = intent.getSerializableExtra(IMAGE_NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent
        val context = this
    }
    override fun onStart() {
        super.onStart()

        image_view.setImageURI(Uri.parse(images.toString()))


    }
}


