package com.pack.castronuevoradio

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val intent = intent


        val fullName = intent.getStringExtra("FULL_NAME")
        val email = intent.getStringExtra("EMAIL")
        val password = intent.getStringExtra("PASSWORD")
        val gender = intent.getStringExtra("GENDER")


        val fullNameTextView: TextView = findViewById(R.id.fullNameTextView)
        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val passwordTextView: TextView = findViewById(R.id.passwordTextView)
        val genderTextView: TextView = findViewById(R.id.genderTextView)


        fullNameTextView.text = "Full Name: $fullName"
        emailTextView.text = "Email: $email"
        passwordTextView.text = "Password: $password"
        genderTextView.text = "Gender: $gender"
    }
}
