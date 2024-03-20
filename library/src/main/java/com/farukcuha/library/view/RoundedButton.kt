package com.farukcuha.library.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.farukcuha.library.theme.LocalSpacing
import com.google.android.material.progressindicator.CircularProgressIndicator

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    text: String = "",
    icon: @Composable () -> Unit = {},
    isLoading: Boolean = false,
    isEnabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) CircularProgressIndicator(
            modifier = Modifier.size(48.dp),
            color = MaterialTheme.colorScheme.primary
        )
        else Button(
            modifier = modifier.height(48.dp),
            onClick = onClick,
            enabled = isEnabled,
            shape = RoundedCornerShape(50),
            colors = colors
        ) {
            Row {
                icon()
                Spacer(LocalSpacing.current.xSmall)
            }
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}