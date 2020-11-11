package com.example.uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val step = 1
        val max = 60 //Max age
        val min = 18 //Mini age
        val seekBar : SeekBar = findViewById(R.id.seekBar) as SeekBar
        seekBar.setMax((max - min) / step)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, i: Int, fromUser: Boolean) {
                val value = (min + (i * step))
                findViewById<TextView>(R.id.age).setText("$value")
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext,"Age: ${findViewById<TextView>(R.id.age).text}",Toast.LENGTH_SHORT).show()
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext,"Age: ${findViewById<TextView>(R.id.age).text}",Toast.LENGTH_SHORT).show()
            }
        })

        findViewById<Button>(R.id.Next).setOnClickListener{ nextPage(
                findViewById<EditText>(R.id.fname).text.toString(),
                findViewById<EditText>(R.id.lname).text.toString(),
                findViewById<EditText>(R.id.email).text.toString(),
                findViewById<TextView>(R.id.age).text.toString()
        ) }
    }
    private fun nextPage(fname: String, lname: String, email: String, age: String) {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("firstName", fname)
        intent.putExtra("lastName", lname)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        startActivity(intent)
    }
}
