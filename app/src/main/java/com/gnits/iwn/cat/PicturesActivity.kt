package com.gnits.iwn.cat

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.rememberImagePainter
import com.gnits.iwn.R
import com.gnits.iwn.cat.ui.theme.IwnTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CategoryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        super.onCreate(savedInstanceState)
        setContent {
            IwnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val categoryState=viewModel.categoryState.collectAsState().value
                    viewModel.fetchCategories()
                    if(categoryState.progressShown){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize()
                        )
                    }else {
                        WelcomeComponent(categoryState)
                    }
                }
            }
        }
    }
}


@Composable
fun WelcomeComponent(categoryState: CategoryState) {
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
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(categoryState.categories) { category ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Image(
                        painter = rememberImagePainter(category.imageUrl),
                        contentDescription = "My Image",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .width(170.dp)
                            .height(200.dp)
                    )
                    Text(text = category.title)
                }
            }
        }

    }
}
