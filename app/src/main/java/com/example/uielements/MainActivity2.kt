package com.example.uielements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //
        val picker: DatePicker = findViewById<DatePicker>(R.id.calendarView)
        var birthdate = "${picker.month}/${picker.dayOfMonth}/${picker.year}"
        picker.init(1999, 11, 11, object: DatePicker.OnDateChangedListener{
            override fun onDateChanged(
                    view: DatePicker?,
                    year: Int,
                    monthOfYear: Int,
                    dayOfMonth: Int
            ) {
                birthdate = "${picker.month + 1}/${picker.dayOfMonth}/${picker.year}"
            }
        })
        findViewById<Button>(R.id.signup).setOnClickListener{ signUp(
                //Parameters
                intent.getStringExtra("firstName").toString(),
                intent.getStringExtra("lastName").toString(),
                intent.getStringExtra("email").toString(),
                intent.getStringExtra("age").toString(),
                findViewById<EditText>(R.id.phonenum).text.toString(),
                birthdate
        )}
        findViewById<Switch>(R.id.phone).setOnClickListener {phonenum()}
    }
    private fun phonenum() {
        val switch: Switch = findViewById<Switch>(R.id.phone) as Switch
        if (switch.isChecked() == true ) {
            findViewById<EditText>(R.id.phonenum).isVisible = true
        } else if (switch.isChecked() == false ) {
            findViewById<EditText>(R.id.phonenum).isVisible = false
        }
    }
    private fun signUp(firstName: String, lastName: String, email: String, age: String, phoneNumber: String, birthDate: String) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("firstName", firstName)
        intent.putExtra("lastName", lastName)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        intent.putExtra("birthDate", birthDate)

        val switch: Switch = findViewById<Switch>(R.id.phone)
        if (switch.isChecked() == true) {
            intent.putExtra("phoneNumber", phoneNumber)
        } else if (switch.isChecked() == false ) {
            intent.putExtra("phoneNumber", "No phone number")
        }
        startActivity(intent)
    }

}


