package com.example.foodsage

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodsage.ui.theme.FoodSageTheme

class MainActivity : ComponentActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)

        login.setOnClickListener {
            if (validateInput()) {
                Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
                //TODO: Implement your login logic here
            }
        }
    }

    private fun validateInput(): Boolean {
        return when {
            username.text.isBlank() -> {
                username.error = "Username cannot be empty"
                false
            }
            password.text.isBlank() -> {
                password.error = "Password cannot be empty"
                false
            }
            else -> true
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSageTheme {
        Greeting("Android")
    }
}