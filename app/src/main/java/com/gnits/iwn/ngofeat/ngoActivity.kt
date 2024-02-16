package com.gnits.iwn.ngofeat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import coil.compose.AsyncImage
import com.gnits.iwn.Post.Block
import com.gnits.iwn.R
import com.gnits.iwn.ngofeat.ui.theme.IwnTheme

class ngoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IwnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
               ngofetch()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ngofetch() {
Column(modifier=Modifier.fillMaxWidth()) {
    Block()
    Block("Environment Event")
    AsyncImage(
        model="https://www.wikiimpact.com/wp-content/uploads/2023/06/Environment.jpeg",
        placeholder = painterResource(id = R.drawable.img_5),
        contentDescription = "Medication",
        modifier = Modifier.height(400.dp)

    )
DateTimeScreen()
}
}
@Composable
fun DateTimeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Date:",
        )
        Text(
            text = "20th January 2024",
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Time:",
        )
        Text(
            text ="9:00 A.M",
        )
        Spacer(modifier = Modifier.height(16.dp))


        Row{
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Schedule")
            }
            Spacer(modifier = Modifier.padding(end = 150.dp))
        Button(onClick = { /*TODO*/ }) {

            Text(text = "Impact")
        }

        }
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Volunteer")
        }

    }
}
