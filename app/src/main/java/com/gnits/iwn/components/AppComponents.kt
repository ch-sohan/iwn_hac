package com.gnits.iwn.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComponent(value:String)
{
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min=80.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )


    )
}
@Composable
fun HeadingTextComponent(value:String)
{
    Text(
        text = value,
        modifier = Modifier.fillMaxWidth().heightIn(min=80.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )


    )
}