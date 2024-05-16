package com.hank.bmi

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hank.bmi.ui.theme.BmiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    SearchBar()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) { //Compose方法第一遠字要大寫
//    Box(modifier = modifier){ //疊在一起
//    Row { //橫
    Column { //欄
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(text = "Text2")
        Text(text = "Text3")
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier){ //Compose方法第一遠字要大寫
    Column {
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                androidx.compose.material3.Icon(imageVector = Icons.Default.Search, contentDescription = "")
            },
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
/*
fun GreetingPreview() { //Compose方法第一遠字要大寫
    BmiTheme {
        Greeting("Android")
    }
}*/

fun MyPreview() { //Compose方法第一遠字要大寫
    BmiTheme {
       SearchBar()
    }
}