package com.farukcuha.library.view.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farukcuha.library.R
import com.farukcuha.library.theme.LocalSpacing
import com.farukcuha.library.view.AppTheme
import com.farukcuha.library.view.RoundedButton

@Composable
fun CheckMailScreenContent(
    modifier: Modifier = Modifier,
    buttonText: String = "Enter code manually",
    onClickButton: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
        RoundedButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = buttonText,
        ) {
            onClickButton()
        }
    }
}

@Composable
@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
fun CheckMailScreenPreview() {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            CheckMailScreenContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(LocalSpacing.current.medium)
            ) {

            }
        }
    }
}