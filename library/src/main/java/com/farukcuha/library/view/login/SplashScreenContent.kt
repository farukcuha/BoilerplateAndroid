package com.farukcuha.library.view.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farukcuha.library.R
import com.farukcuha.library.theme.LocalSpacing
import com.farukcuha.library.view.AppTheme
import com.farukcuha.library.view.RoundedButton
import com.farukcuha.library.view.Spacer

@Composable
fun SplashScreenContent(
    modifier: Modifier = Modifier,
    image: Painter = painterResource(R.drawable.logo),
    title: String = "Hey! Welcome",
    body: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    buttonContainerColor: Color = MaterialTheme.colorScheme.secondary,
    buttonContentColor: Color = MaterialTheme.colorScheme.onSecondary,
    onClickButton: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(320.dp)
        )
        Spacer(LocalSpacing.current.medium)
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.SemiBold,
            color = textColor,
            textAlign = TextAlign.Center
        )
        Spacer(LocalSpacing.current.small)
        Text(
            text = body,
            style = MaterialTheme.typography.bodyMedium,
            color = textColor,
            textAlign = TextAlign.Center
        )
        Spacer(LocalSpacing.current.medium)
        RoundedButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Get Started",
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonContainerColor,
                contentColor = buttonContentColor
            )
        ) {
            onClickButton()
        }
    }
}

@Composable
@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
fun SplashScreenPreview() {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            SplashScreenContent(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = LocalSpacing.current.medium),
                textColor = MaterialTheme.colorScheme.onSecondary,
            )
        }
    }
}