package com.gnits.iwn.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gnits.iwn.components.HeadingTextComponent
import com.gnits.iwn.components.NormalTextComponent

@Composable
fun SignUpScreen()
{
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
      //HeadingTextComponent(value = stringResource(id = ))
    // NormalTextComponent(value = stringResource(id = R.string.hello) )
    }
}
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen()
{
    SignUpScreen()
}