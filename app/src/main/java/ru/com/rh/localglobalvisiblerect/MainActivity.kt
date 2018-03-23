package ru.com.rh.localglobalvisiblerect

import android.annotation.SuppressLint
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var lastX: Int = 0
    private var lastY: Int = 0

    private lateinit var main: View
    private lateinit var img: CustomImageView
    private lateinit var local: TextView
    private lateinit var global: TextView
    private lateinit var offset: TextView
    private lateinit var isShown: TextView
    private lateinit var percents: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main = findViewById<View>(R.id.container)
        img = findViewById(R.id.img)
        local = findViewById(R.id.local)
        global = findViewById(R.id.global)
        offset = findViewById(R.id.offset)
        isShown = findViewById(R.id.isShown)
        percents = findViewById(R.id.percents)

        main.viewTreeObserver.addOnGlobalLayoutListener {
            val localRect = Rect()
            val isLocalVisible = img.getLocalVisibleRect(localRect)
            local.text = "local" + localRect.toString() + " - " + isLocalVisible.toString()

            val globalRect = Rect()
            val globalOffset = Point()
            val isGlobalVisible = img.getGlobalVisibleRect(globalRect, globalOffset)
            global.text = "global" + globalRect.toString() + " - " + isGlobalVisible.toString()
            offset.text = "globalOffset:" + globalOffset.x + "," + globalOffset.y

            isShown.text = "is shown:" + img.isShown.toString()
            percents.text = "percents: " + getVisiblePercent(img)
        }

        val imageView = findViewById<View>(R.id.img)
        imageView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lastX = event.rawX.toInt()
                    lastY = event.rawY.toInt()
                }
                MotionEvent.ACTION_MOVE -> {
                    val dx = event.rawX.toInt() - lastX
                    val dy = event.rawY.toInt() - lastY

                    val left = v.getLeft() + dx
                    val top = v.getTop() + dy
                    val right = v.getRight() + dx
                    val bottom = v.getBottom() + dy

                    v.layout(left, top, right, bottom)
                    lastX = event.rawX.toInt()
                    lastY = event.rawY.toInt()
//
//                    val localRect = Rect()
//                    val isLocalVisible = v.getLocalVisibleRect(localRect)
//                    local.text = "local" + localRect.toString() + " - " + isLocalVisible.toString()
//
//                    val globalRect = Rect()
//                    val globalOffset = Point()
//                    val isGlobalVisible = v.getGlobalVisibleRect(globalRect, globalOffset)
//                    global.text = "global" + globalRect.toString() + " - " + isGlobalVisible.toString()
//                    offset.text = "globalOffset:" + globalOffset.x + "," + globalOffset.y
//
//                    isShown.text = "is shown:" + v.isShown.toString()
//                    percents.text = "percents: " + getVisiblePercent(v)
                }
            }
            true
        }

    }

    private fun getVisiblePercent(v: View): Int {
        return if (v.isShown) {
            val r = Rect()
            if (v.getLocalVisibleRect(r)) {
                val sVisible = (r.width() * r.height()).toDouble()
                val sTotal = (v.width * v.height).toDouble()
                (100 * sVisible / sTotal).toInt()
            } else {
                0
            }
        } else {
            0
        }
    }
}
