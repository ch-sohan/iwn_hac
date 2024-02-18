package com.gnits.iwn.Post

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import com.gnits.iwn.Post.ui.theme.IwnTheme
import com.gnits.iwn.R
import com.gnits.iwn.congo.StarActivity
import com.gnits.iwn.ngofeat.ngoActivity

class PostActivity : ComponentActivity() {
    private lateinit var viewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[PostViewModel::class.java]
        super.onCreate(savedInstanceState)
        setContent {
            IwnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val postState = viewModel.postState.collectAsState().value
                    if(postState.progressShown){
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(100.dp)
                        )
                    } else {
                        LazyColumn {
                            items(postState.posts) {post ->
                                when(post.type) {
                                    "Event" -> {
                                        EventPost(post = post, onVolunteerClicked = {
                                            // TODO : can add the link in firestore
                                            val url = "https://docs.google.com/forms/d/1ZDM9_dQMwicwNxYyhGt7vYKLEu9fBty8qhoeoJxKgMQ/edit"//form link
                                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                            startActivity(intent)
                                        })
                                    }
                                    "Donation" -> {
                                        DonationPost(
                                            post = post,
                                            onDonateClicked = {
                                                // TODO : add upi link url in firestore
                                                val upiUri = Uri.parse("upi://pay?pa=example@upi&pn=Example%20Name&mc=123&tid=123456&tr=123456789&tn=Payment%20for%20something&am=10.00&cu=INR")
                                                val intent = Intent(Intent.ACTION_VIEW, upiUri)
                                                startActivity(intent)
                                            },
                                            onImpactClicked = {
                                                val intent = Intent(this@PostActivity, StarActivity::class.java)
                                                startActivity(intent)
                                            }
                                        )
                                    }
                                    "Opportunity" -> {
                                        OpportunityPost(post = post, onVolunteerClicked = {
                                            // TODO : can add the link in firestore
                                            val url = "https://www.example.com"
                                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                            startActivity(intent)
                                        })
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun EventPost(
    post: Post,
    onVolunteerClicked: (Post) -> Unit,

    ) {
    Column(modifier=Modifier.padding(horizontal = 5.dp)){
        Row {

            AsyncImage(
                model = post.ngoImageUrl,
                placeholder = painterResource(id = R.drawable.profile),
                contentDescription = "Medication",
                modifier = Modifier.height(40.dp)
            )
            Text(text = post.ngoName, fontSize = 30.sp)
        }
        AsyncImage(
            model = post.imageUrl,
            placeholder = painterResource(id = R.drawable.img),
            contentDescription = "Medication",
            modifier = Modifier
                .height(300.dp)

        )
        Row {
            Column() {
                OutlinedHeartIcon()
                Text(
                    text = post.nooflikes.toString(),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color =Color.Red
                )
            }
            Column() {
                OutlinedCommentIcon()
                Text(
                    text = post.noofcomments.toString(),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color =Color.Red
                )
            }
            Column() {
                OutlinedShareIcon()
                Text(
                    text = post.noofshares.toString(),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color =Color.Red
                )
            }

            Spacer(modifier = Modifier.padding(end=200.dp))
            OutlinedBookIcon()
        }
        Text(text=post.title, fontSize = 18.sp, fontWeight = FontWeight.Medium)

        Text(text = post.description)
        Text(
            text = post.category,
            modifier = Modifier.padding(),
            color = Color.Blue
        )

        Text(
            text = post.nooflikes.toString()+"likes",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofcomments.toString()+"comments",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofshares.toString()+"shares",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Spacer(modifier=Modifier.weight(1f))
        Row() {
            Button(onClick = { onVolunteerClicked(post) }) {
                Text(text = "Volunteer")
            }

        }

    }

}

@Preview
@Composable
fun DonationPost(
    post: Post = Post(),
    onDonateClicked: (Post) -> Unit = {},
    onImpactClicked: (Post) -> Unit = {}
) {
    Column(
        modifier=Modifier.padding(horizontal = 5.dp)
    ){
        Row {
            AsyncImage(
                model = post.ngoImageUrl,
                placeholder = painterResource(id = R.drawable.profile),
                contentDescription = "Medication",
                modifier = Modifier.height(40.dp)
            )
            Text(text = post.ngoName, fontSize = 30.sp)
        }
        AsyncImage(
            model = post.imageUrl,
            placeholder = painterResource(id = R.drawable.img),
            contentDescription = "Medication",
            modifier = Modifier
                .height(300.dp)
        )
        Row {
            Column() {
                OutlinedHeartIcon()
                Text(
                    text = post.nooflikes.toString(),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color =Color.Red
                )
            }
            Column() {
                OutlinedCommentIcon()
                Text(
                    text = post.noofcomments.toString(),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color =Color.Red
                )
            }
            Column() {
                OutlinedShareIcon()
                Text(
                    text = post.noofshares.toString(),
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color =Color.Red
                )
            }

            Spacer(modifier = Modifier.padding(end=200.dp))
            OutlinedBookIcon()
        }
        Text(text=post.title, fontSize = 18.sp, modifier = Modifier.padding(horizontal = 5.dp), fontWeight = FontWeight.Medium)

        Text(text = post.description)
        Text(
            text = post.category,
            modifier = Modifier.padding(),
            color = Color.Blue
        )

        Text(
            text = post.nooflikes.toString()+"likes",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofcomments.toString()+"comments",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofshares.toString()+"shares",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Row {
            Button(onClick = { onDonateClicked(post) }) {
                Text(text = "Donate")
            }
            Button(onClick = { onImpactClicked(post) }) {
                Text(text = "Impact")
            }


        }
    }
}

@Composable
fun OpportunityPost(
    post: Post,
    onVolunteerClicked: (Post) -> Unit
) {
    Column{
        Block()
        Block(" Post")
        Block("",FontWeight.Normal,Color.White)
        Row {

            AsyncImage(
                model = "https://www.freeiconspng.com/thumbs/report-icon/call-report-icon-3.png",
                placeholder = painterResource(id = R.drawable.profile),
                contentDescription = "Medication",
                modifier = Modifier.height(40.dp)
            )
            Text(text = "  Justin", fontSize = 30.sp)
        }
        AsyncImage(
            model = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.healthshots.com%2Fhealthshots%2Fen%2Fuploads%2F2022%2F05%2F11184715%2FYoga-for-weight-loss.jpg&tbnid=KdZQfZ4Gp3lB1M&vet=12ahUKEwi237Lvn7CEAxX5kGMGHdVFA98QMygCegQIARBy..i&imgrefurl=https%3A%2F%2Fwww.healthshots.com%2Ffitness%2Fstaying-fit%2Fhow-does-yoga-benefit-your-mind-body-and-soul%2F&docid=Ju-5PPwk9OiWHM&w=1600&h=900&q=yoga&ved=2ahUKEwi237Lvn7CEAxX5kGMGHdVFA98QMygCegQIARBy",
            placeholder = painterResource(id = R.drawable.img),
            contentDescription = "Medication",
            modifier = Modifier
                .height(300.dp)

        )
        Row {
            OutlinedHeartIcon()
            OutlinedCommentIcon()
            OutlinedShareIcon()
            Spacer(modifier = Modifier.padding(end=200.dp))
            OutlinedBookIcon()
        }
        Text(text=post.title, fontSize = 18.sp, fontWeight = FontWeight.Medium)

        Text(text = post.description)
        Text(
            text = post.category,
            modifier = Modifier.padding(),
            color = Color.Blue
        )

        Text(
            text = post.nooflikes.toString()+"likes",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofcomments.toString()+"comments",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofshares.toString()+"shares",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Spacer(modifier=Modifier.weight(1f))

        Row {

            AsyncImage(
                model="https://th.bing.com/th?id=OIP.Pw3Av1lYJIH3uPqX3axEzAHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2",
                placeholder = painterResource(id = R.drawable.img_1),
                contentDescription = "Medication",
                modifier = Modifier.height(50.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))
            AsyncImage(
                model="https://th.bing.com/th?id=OIP._RTO9yp1xH5aQA0vS7fpHAHaHW&w=250&h=249&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2",
                placeholder = painterResource(id = R.drawable.img_2),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))


            AsyncImage(
                model="https://static.vecteezy.com/system/resources/previews/006/082/534/original/add-button-flat-icon-vector.jpg",
                placeholder = painterResource(id = R.drawable.img_3),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))

            AsyncImage(
                model="https://media.istockphoto.com/id/1265127017/vector/instagramm-reels-icon-line-vector-illustration.jpg?s=612x612&w=0&k=20&c=nZnBU983UH35mAmwoxtJHyLVLNo6y-DG6BDDRc_t9HY=",
                placeholder = painterResource(id = R.drawable.img_4),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))
            AsyncImage(
                model = "https://images.healthshots.com/healthshots/en/uploads/2022/05/11184715/Yoga-for-weight-loss.jpg",
                placeholder = painterResource(id = R.drawable.profile),
                contentDescription = "Medication",
                modifier = Modifier.height(40.dp)
            )
        }
    }
}


@Composable
fun PostWithActions(
    post: Post,
    onDonateClicked: (Post) -> Unit,
    onVolunteerClicked: (Post) -> Unit
) {
    Column{
        Block()
        Block(" Post")
        Block("",FontWeight.Normal,Color.White)
        Row {

            AsyncImage(
                model = "https://www.freeiconspng.com/thumbs/report-icon/call-report-icon-3.png",
                placeholder = painterResource(id = R.drawable.profile),
                contentDescription = "Medication",
                modifier = Modifier.height(40.dp)
            )
            Text(text = "  Justin", fontSize = 30.sp)
        }
        AsyncImage(
            model = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.healthshots.com%2Fhealthshots%2Fen%2Fuploads%2F2022%2F05%2F11184715%2FYoga-for-weight-loss.jpg&tbnid=KdZQfZ4Gp3lB1M&vet=12ahUKEwi237Lvn7CEAxX5kGMGHdVFA98QMygCegQIARBy..i&imgrefurl=https%3A%2F%2Fwww.healthshots.com%2Ffitness%2Fstaying-fit%2Fhow-does-yoga-benefit-your-mind-body-and-soul%2F&docid=Ju-5PPwk9OiWHM&w=1600&h=900&q=yoga&ved=2ahUKEwi237Lvn7CEAxX5kGMGHdVFA98QMygCegQIARBy",
            placeholder = painterResource(id = R.drawable.img),
            contentDescription = "Medication",
            modifier = Modifier
                .height(300.dp)

        )
        Row {
            OutlinedHeartIcon()
            OutlinedCommentIcon()
            OutlinedShareIcon()
            Spacer(modifier = Modifier.padding(end=200.dp))
            OutlinedBookIcon()
        }
        Text(text=post.title, fontSize = 18.sp, fontWeight = FontWeight.Medium)

        Text(text = post.description)
        Text(
            text = post.category,
            modifier = Modifier.padding(),
            color = Color.Blue
        )

        Text(
            text = post.nooflikes.toString()+"likes",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofcomments.toString()+"comments",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Text(
            text = post.noofshares.toString()+"shares",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Spacer(modifier=Modifier.weight(1f))

        Row {

            AsyncImage(
                model="https://th.bing.com/th?id=OIP.Pw3Av1lYJIH3uPqX3axEzAHaHa&w=250&h=250&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2",
                placeholder = painterResource(id = R.drawable.img_1),
                contentDescription = "Medication",
                modifier = Modifier.height(50.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))
            AsyncImage(
                model="https://th.bing.com/th?id=OIP._RTO9yp1xH5aQA0vS7fpHAHaHW&w=250&h=249&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2",
                placeholder = painterResource(id = R.drawable.img_2),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))


            AsyncImage(
                model="https://static.vecteezy.com/system/resources/previews/006/082/534/original/add-button-flat-icon-vector.jpg",
                placeholder = painterResource(id = R.drawable.img_3),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))

            AsyncImage(
                model="https://media.istockphoto.com/id/1265127017/vector/instagramm-reels-icon-line-vector-illustration.jpg?s=612x612&w=0&k=20&c=nZnBU983UH35mAmwoxtJHyLVLNo6y-DG6BDDRc_t9HY=",
                placeholder = painterResource(id = R.drawable.img_4),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))
            AsyncImage(
                model = "https://images.healthshots.com/healthshots/en/uploads/2022/05/11184715/Yoga-for-weight-loss.jpg",
                placeholder = painterResource(id = R.drawable.profile),
                contentDescription = "Medication",
                modifier = Modifier.height(40.dp)
            )
        }
    }
}
@Composable
fun Block(
    text: String = "",
    fontWeight: FontWeight = FontWeight.Normal, // Default to normal font weight

    bgColor: androidx.compose.ui.graphics.Color = BlockColors.Color1,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(bgColor)
            .fillMaxWidth()

    ) {
        Text (text = text,
            modifier = modifier
                .padding(1.dp),
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 25.sp,
            style = LocalTextStyle.current.copy(fontWeight = fontWeight)
        )
    }
}
object BlockColors {
    val Color1 = androidx.compose.ui.graphics.Color.Black
    val Color2 = Color(203,178,255)
    val Color3 = Color(253,174,131)
    val Color4 = Color(243,109,95)
    val Color5 = Color(255,178,215)
    val Color6 = Color(180,238,180)
    val Color7 = Color(207,234,217)
    val Color8 = Color(238,221,130)
}
@Composable
fun OutlinedHeartIcon() {
    // Using the outlined heart icon
    Icon(
        imageVector = Icons.Outlined.Favorite,
        contentDescription = null, // Set a meaningful description if needed
        modifier = Modifier
            .size(50.dp) // Adjust the size as needed
            .padding(bottom = 10.dp) // Adjust padding as needed
    )
}
@Composable
fun OutlinedShareIcon() {
    // Using the outlined heart icon
    Icon(
        imageVector = Icons.Outlined.Send,
        contentDescription = null, // Set a meaningful description if needed
        modifier = Modifier
            .size(50.dp) // Adjust the size as needed
            .padding(bottom = 10.dp) // Adjust padding as needed
    )
}
@Composable
fun OutlinedBookIcon() {
    // Using the outlined heart icon
    Icon(
        imageVector = Icons.Outlined.Bookmark,
        contentDescription = null, // Set a meaningful description if needed
        modifier = Modifier
            .size(50.dp) // Adjust the size as needed
            .padding(bottom = 10.dp) // Adjust padding as needed
    )
}
@Composable
fun OutlinedCommentIcon() {
    // Using the outlined heart icon
    Icon(
        imageVector = Icons.Outlined.Comment,
        contentDescription = null, // Set a meaningful description if needed
        modifier = Modifier
            .size(50.dp) // Adjust the size as needed
            .padding(bottom = 10.dp) // Adjust padding as needed
    )
}