package com.example.tutorial_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Add a text element
            // Text("Hello world!")
            MessageCard(name = "Android 13")
        }
    }
}

// Define a composable function
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}

// Preview your function in Android Studio
@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(name = "Android")
}