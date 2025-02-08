package com.fredymar.dicegameapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fredymar.dicegameapplication.ui.theme.DiceGameApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceGameApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Canvas(modifier = Modifier.size(96.dp, 96.dp).align(Alignment.Center)) {
            drawRoundRect(
                Color.Magenta,
                cornerRadius = CornerRadius(24f, 24f),
                topLeft = Offset(10f, 10f),
                size = size
            )
            drawCircle(
                Color.Black,
                radius = Dp(24f).value,
                center = Offset(size.width / 2, size.height / 2)
            )
        }

        Button(onClick = { }, modifier = Modifier
            .align(Alignment.Center)
            .offset(y = (120).dp)
        ) {
            Text("Jugar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiceGameApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            App()
        }
    }
}