package com.farukcuha.library.view

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorDialog(
    title: String = "Error",
    message: String = "Unknown Error!",
    dismissButtonText: String = "Close",
    onDismiss: () -> Unit,
) {
    AlertDialog(
        title = { Text(text = title, color = MaterialTheme.colorScheme.error) },
        text = { Text(text = message) },
        onDismissRequest = { onDismiss() },
        confirmButton = {},
        dismissButton = {
            Button(
                onClick = { onDismiss() },
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text(dismissButtonText)
            }
        }
    )
}