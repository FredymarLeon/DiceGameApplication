package com.fredymar.dicegameapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.motionEventSpy
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
                    App(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

fun DrawScope.circle(offset: (Float) -> Offset){
    val radius = Dp(20f).value
    drawCircle(
        Color.Black,
        radius = radius,
        center =offset(radius)
    )
}

fun DrawScope.center(){
    circle{
        Offset(size.width / 2f, size.height / 2f)
    }
}

fun DrawScope.topRight(){
    circle{
        Offset(size.width - it * 2f, it * 2f)
    }
}

fun DrawScope.topLeft(){
    circle {
        Offset(it * 2f, it * 2f)
    }
}

fun DrawScope.bottomLeft(){
    circle {
        Offset(it * 2f,size.height - (it * 2f))
    }
}

fun DrawScope.bottomRight(){
    circle {
        Offset(size.width - (it * 2f),size.height - (it * 2f))
    }
}
fun DrawScope.bullet(number: Int) {
    when(number) {
        1-> {
            center()
        }
        2-> {
            topRight()
            bottomLeft()
        }
        3-> {
            topRight()
            center()
            bottomLeft()
        }
        4 -> {
            topLeft()
            topRight()
            bottomLeft()
            bottomRight()

        }
    }
}

@Composable
fun Dice(number: Int, modifier: Modifier){
    Canvas(
        modifier = Modifier
            .size(96.dp, 96.dp)
    ) {
        drawRoundRect(
            Color.Magenta,
            cornerRadius = CornerRadius(24f, 24f),
            size = size
        )

        bullet(number = number)
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Dice(1,Modifier)
            Dice(2,Modifier)
            Dice(3, Modifier)
            Dice(4, Modifier)

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { }) {
                Text("Jogar")
            }
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