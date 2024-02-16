package com.gnits.iwn.Post

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gnits.iwn.Post.ui.theme.IwnTheme
import com.gnits.iwn.R

class PostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IwnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                postaction()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun postaction() {
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
        Text(text="Yoga Workshop", fontSize = 18.sp)

        Text(text = "Helps you focus on your practice and learn tools and techniques in a guided way")
        Text(
            text = "#Health and Social Care",
            modifier = Modifier.padding(),
            color = Color.Blue
        )

        Text(
            text = "Liked by 20000",
            modifier = Modifier.padding(),
            color =BlockColors.Color2
        )
        Spacer(modifier=Modifier.weight(1f))

        Row {

            AsyncImage(
                model="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.rawpixel.com%2Fsearch%2Fhouse%2520icon&psig=AOvVaw1_fFKHki2E3tRE-5wgud-n&ust=1708186606437000&source=images&cd=vfe&opi=89978449&ved=0CBYQjRxqFwoTCPDHg5GhsIQDFQAAAAAdAAAAABAE",
                placeholder = painterResource(id = R.drawable.img_1),
                contentDescription = "Medication",
                modifier = Modifier.height(50.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))
            AsyncImage(
                model="https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pngitem.com%2Fmiddle%2Fmwoxmm_search-icon-small-search-icons-hd-png-download%2F&psig=AOvVaw1_zIntFUktrkP9ZSifKvOy&ust=1708186894574000&source=images&cd=vfe&opi=89978449&ved=0CBYQjRxqFwoTCPifo5qisIQDFQAAAAAdAAAAABAF",
                placeholder = painterResource(id = R.drawable.img_2),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))


            AsyncImage(
                model="https://www.google.com/imgres?imgurl=https%3A%2F%2Fstatic.vecteezy.com%2Fsystem%2Fresources%2Fpreviews%2F006%2F082%2F534%2Foriginal%2Fadd-button-flat-icon-vector.jpg&tbnid=uNapRIw1vswiaM&vet=12ahUKEwiZtf7ZorCEAxULbGwGHXosAawQMygLegQIARBg..i&imgrefurl=https%3A%2F%2Fwww.vecteezy.com%2Fvector-art%2F6082534-add-button-flat-icon&docid=HlRLO2IintGonM&w=1920&h=1920&q=add%20icon%20in%20insta&ved=2ahUKEwiZtf7ZorCEAxULbGwGHXosAawQMygLegQIARBg",
                placeholder = painterResource(id = R.drawable.img_3),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))

            AsyncImage(
                model="https://www.google.com/imgres?imgurl=https%3A%2F%2Fmedia.istockphoto.com%2Fid%2F1265127017%2Fvector%2Finstagramm-reels-icon-line-vector-illustration.jpg%3Fs%3D612x612%26w%3D0%26k%3D20%26c%3DnZnBU983UH35mAmwoxtJHyLVLNo6y-DG6BDDRc_t9HY%3D&tbnid=OcVBnKB-5lA_dM&vet=12ahUKEwjluo7Qo7CEAxU1amwGHXOiB2MQMygCegQIARBS..i&imgrefurl=https%3A%2F%2Fwww.istockphoto.com%2Fvector%2Finstagramm-reels-icon-line-vector-illustration-gm1265127017-370722742&docid=N7Zeez4cIxN1wM&w=612&h=612&q=video%20icon%20in%20insta&ved=2ahUKEwjluo7Qo7CEAxU1amwGHXOiB2MQMygCegQIARBS",
                placeholder = painterResource(id = R.drawable.img_4),
                contentDescription = "Medication",
                modifier = Modifier.height(45.dp)

            )
            Spacer(modifier = Modifier.padding(end = 40.dp))
            AsyncImage(
                model = "https://www.freeiconspng.com/thumbs/report-icon/call-report-icon-3.png",
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