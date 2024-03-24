package com.farukcuha.library.view.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farukcuha.library.R
import com.farukcuha.library.theme.LocalSpacing
import com.farukcuha.library.view.AppTheme
import com.farukcuha.library.view.OtpTextField
import com.farukcuha.library.view.RoundedButton
import com.farukcuha.library.view.Spacer

@Composable
fun OTPScreenContent(
    modifier: Modifier = Modifier,
    image: Painter = painterResource(R.drawable.logo),
    title: String = "Enter 6 digit code",
    otpLength: Int = 4,
    otpCodeValue: String? = null,
    onOTPValueChange: (String) -> Unit = {},
    buttonText: String = "Continue with login code",
    loading: Boolean = false,
    onClickContinue: () -> Unit = {}
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Spacer(LocalSpacing.current.medium)
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(LocalSpacing.current.medium)
            OtpTextField(
                modifier = Modifier.padding(horizontal = LocalSpacing.current.medium),
                value = otpCodeValue ?: "",
                onValueChange = onOTPValueChange,
                length = otpLength
            )
            Spacer(LocalSpacing.current.large)
            RoundedButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = buttonText,
                isEnabled = otpCodeValue?.length == otpLength,
                isLoading = loading
            ) {
                onClickContinue()
            }
        }
    }
}

@Composable
@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
fun OTPScreenPreview() {
    var value by remember { mutableStateOf("") }
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            OTPScreenContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(LocalSpacing.current.medium),
                otpCodeValue = value,
                onOTPValueChange = {
                    value = it
                }
            )
        }
    }
}