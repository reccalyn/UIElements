package com.example.uielements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        findViewById<TextView>(R.id.fname3).setText("First Name: ${(intent.getStringExtra("firstName"))}")
        findViewById<TextView>(R.id.lname3).setText("Last Name: ${( intent.getStringExtra("lastName"))}")
        findViewById<TextView>(R.id.email3).setText("Email: ${( intent.getStringExtra("email"))}")
        findViewById<TextView>(R.id.age3).setText("Age: ${( intent.getStringExtra("age"))}")
        findViewById<TextView>(R.id.bday3).setText("Birthday: ${( intent.getStringExtra("birthDate") )}")
        findViewById<TextView>(R.id.phone3).setText("Number: ${ (intent.getStringExtra("phoneNumber"))}")

    }
}