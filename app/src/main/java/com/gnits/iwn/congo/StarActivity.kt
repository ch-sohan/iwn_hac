package com.gnits.iwn.congo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gnits.iwn.R
import com.gnits.iwn.congo.ui.theme.IwnTheme

class StarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IwnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomeComponent(){
    val backgroundColor = Color.White
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(top = 0.dp, bottom = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.star1),
            contentDescription = "My Image",
            modifier = Modifier
                .padding(bottom = 0.dp)
                .width(500.dp)
                .height(400.dp)
        )
        Middle()
        GetButton()
    }
}
@Composable
fun Middle() {

    Text(
        text = "You have earned 100 Points",
        style = boldItalicTextStyle()
    )
    Text(
        text = "You saved 56 lives",
        style = boldItalicTextStyle()
    )

}
@Composable
fun boldItalicTextStyle(): TextStyle {
    return TextStyle(
        color=Color.Black,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
}
@Composable
fun GetButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(top = 40.dp, bottom = 12.dp)
            .width(200.dp)
            .height(60.dp)

    ) {
        Text(text = "CONTINUE",

            )
    }
}
