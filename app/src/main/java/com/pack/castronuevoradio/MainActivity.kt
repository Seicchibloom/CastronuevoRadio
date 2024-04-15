package com.pack.castronuevoradio

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.pack.castronuevoradio.R // Import the R class for accessing resources

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fullNameEditText: EditText = findViewById(R.id.fullNameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.editTextTextPassword)
        val maleRadioButton: RadioButton = findViewById(R.id.maleRadioButton)
        val femaleRadioButton: RadioButton = findViewById(R.id.femaleRadioButton)
        val otherRadioButton: RadioButton = findViewById(R.id.otherRadioButton)
        val submitButton: Button = findViewById(R.id.submitButton)
        val showPasswordButton: Button = findViewById(R.id.showPasswordButton)

        var passwordVisible = false

        showPasswordButton.setOnClickListener {
            passwordVisible = !passwordVisible
            if (passwordVisible) {
                passwordEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                showPasswordButton.text = "Hide Password"
            } else {
                passwordEditText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                showPasswordButton.text = "Show Password"
            }
            // Move the cursor to the end of the text to maintain the current cursor position
            passwordEditText.setSelection(passwordEditText.text.length)
        }
        submitButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val gender = when {
                maleRadioButton.isChecked -> "Male"
                femaleRadioButton.isChecked -> "Female"
                otherRadioButton.isChecked -> "Other"
                else -> ""
            }

            // Validate fields
            var errorOccurred = false

            if (fullName.isEmpty()) {
                fullNameEditText.error = "Full name is required"
                errorOccurred = true
            }

            if (email.isEmpty()) {
                emailEditText.error = "Email is required"
                errorOccurred = true
            }

            if (password.isEmpty()) {
                passwordEditText.error = "Password is required"
                errorOccurred = true
            }

            if (gender.isEmpty()) {
                // Clear previous errors if any
                maleRadioButton.error = null
                femaleRadioButton.error = null
                otherRadioButton.error = "Gender is required"
                errorOccurred = true
            } else {
                // Clear error for gender if gender is selected
                maleRadioButton.error = null
                femaleRadioButton.error = null
                otherRadioButton.error = null
            }

            if (errorOccurred) {
                return@setOnClickListener
            }

            // If all fields are filled, proceed with intent
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("FULL_NAME", fullName)
            intent.putExtra("EMAIL", email)
            intent.putExtra("PASSWORD", password)
            intent.putExtra("GENDER", gender)
            startActivity(intent)
        }
    }
}
