package com.gnits.iwn.view.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gnits.iwn.view.home.ui.theme.IwnTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IwnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    homecomponent()
                }
            }
        }
    }
}

@Composable
fun homecomponent() {
    Icon(
        imageVector = Icons.Filled.List,
        contentDescription = null,
        modifier = Modifier
            .background(Color.Blue)
            .size(50.dp)
    )


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    IwnTheme {
        homecomponent()
    }
}