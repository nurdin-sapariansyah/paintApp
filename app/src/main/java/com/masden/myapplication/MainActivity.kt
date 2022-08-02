package com.masden.myapplication

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.net.VpnService.prepare
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masden.myapplication.PaintView.Companion.colorList
import com.masden.myapplication.PaintView.Companion.currentBrush
import com.masden.myapplication.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {

    private lateinit var data: Array<String>
    private lateinit var rv : RecyclerView
    private var list: ArrayList<DataModel> = arrayListOf()

    companion object{
        var path = Path()
        var paintBrush = Paint()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val blueBtn = findViewById<ImageButton>(R.id.blueColor)
        val blackBtn = findViewById<ImageButton>(R.id.blackColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)

        redBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)
        }
        blueBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }
        blackBtn.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
        }
        eraser.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()
        }

        rv = findViewById(R.id.rv)
        rv.setHasFixedSize(true)

        addItem()
        showRecyclerList()
    }

    private fun prepare() {
        data = resources.getStringArray(R.array.title)
    }

    private fun addItem(): ArrayList<DataModel> {
        prepare()
        for (position in data.indices) {
            val user = DataModel(
                data[position]

            )
            list.add(user)
        }
        return list
    }

    private fun showRecyclerList() {
        rv.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        val listAdapter = Adapter(list)
        rv.adapter = listAdapter
    }

    private fun currentColor(color: Int){
        currentBrush = color
        path = Path()
    }
}