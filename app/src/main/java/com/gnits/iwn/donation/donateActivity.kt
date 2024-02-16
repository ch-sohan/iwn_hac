package com.gnits.iwn.donation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gnits.iwn.Post.Block
import com.gnits.iwn.R
import com.gnits.iwn.donation.ui.theme.IwnTheme

class donateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IwnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    donationScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun donationScreen() {
    Column(modifier=Modifier.fillMaxSize()) {
        Block()
        Block("Education Donation")
        Image(
            painter = painterResource(id = R.drawable.img_6),
            contentDescription = "null",
            modifier= Modifier
                .height(450.dp)
                .fillMaxWidth()

        )
        Row{
        Button(onClick = {}) {
            Text(text = "Impact")}
            Spacer(modifier = Modifier.padding(end = 190.dp))
            Button(onClick = {}) {
                Text(text = "Donation")
            }
}

        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Track")
        }

    }
}