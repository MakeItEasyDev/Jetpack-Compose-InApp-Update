package com.jetpack.inappupdate

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
internal fun UpdateDownloadedView(update: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.in_app_update_compose_update_complete_title),
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
        )

        Text(
            text = stringResource(id = R.string.in_app_update_compose_update_complete_body),
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                update()
            },
            modifier = Modifier
        ) {
            Text(text = stringResource(id = R.string.in_app_update_compose_update_complete_button))
        }
    }
}
















