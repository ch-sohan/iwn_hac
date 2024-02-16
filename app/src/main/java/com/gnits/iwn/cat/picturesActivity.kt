package com.gnits.iwn.cat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gnits.iwn.R
import com.gnits.iwn.cat.ui.theme.IwnTheme

class MainActivity : ComponentActivity() {
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
fun WelcomeComponent() {
    val backgroundColor = Color(65, 115, 148)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .padding(vertical = 20.dp), // Adjusted vertical padding
        horizontalAlignment = Alignment.CenterHorizontally // Aligns children horizontally at the center
    ) {
        Text(
            text = "Categories", // Heading text
            //style = MaterialTheme.typography.h2, // Adjust text style as needed
        )
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.olderpeople),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .width(170.dp)
                        .height(200.dp)
                )
                Text(text = "Older People")
            }
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.community),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .width(170.dp)
                        .height(200.dp)
                )
                Text(text = "Community")
            }
        }
        Spacer(modifier = Modifier.height(8.dp)) // Add space between rows
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.crisis),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .width(170.dp)
                        .height(200.dp)
                )
                Text(text = "Crisis and Welfare", modifier = Modifier.padding(bottom = 16.dp))
            }
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.animal),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .width(170.dp)
                        .height(200.dp)
                )
                Text(text = "Animal Welfare", modifier = Modifier.padding(bottom = 16.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp)) // Add space between rows
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Spacer(modifier = Modifier.padding(horizontal = 8.dp)) // Add spacer at the beginning
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sustainability),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .width(170.dp)
                        .height(200.dp)
                )
                Text(text = "Sustainability", modifier = Modifier.padding(bottom = 16.dp))
            }
            Spacer(modifier = Modifier.padding(horizontal = 8.dp)) // Add spacer between the two columns
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sports),
                    contentDescription = "My Image",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .width(170.dp)
                        .height(200.dp)
                )
                Text(text = "Sports Welfare", modifier = Modifier.padding(bottom = 16.dp))
            }
        }
    }
}
