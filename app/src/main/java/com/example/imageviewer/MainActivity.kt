package com.example.imageviewer

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.net.URI
import java.util.jar.Attributes

class MainActivity : AppCompatActivity() {

    companion object {
        const val IMAGE_REQUEST_CODE = 0
    }

    var imgList: ArrayList<ImageData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgList = ArrayList()

        button_get_image.setOnClickListener {
            val intent = Intent(ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager)!= null) {
                startActivityForResult(intent, IMAGE_REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val imageURI = data?.data
            if (imageURI != null) {
                imgList.add(ImageData(imageURI.toString()))
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    // Creates text view to populate the scroll view with image text
    private fun createTextView(imgName: ImageData): TextView {
        val view = TextView(this)

        view.text = "${imgName}"
        view.textSize = 24f

        return view
    }

    // populateImgData function populates the list of images by adding their names and index from imgList
    fun populateImgData() {
        for(i in 0..imgList.size) {
            linear_scroll.addView(createTextView(imgList[i]))
        }
    }
}

class ImageData(uri: String): Serializable
