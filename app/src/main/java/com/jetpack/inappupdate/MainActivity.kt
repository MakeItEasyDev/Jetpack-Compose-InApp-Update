package com.jetpack.inappupdate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetpack.inappupdate.ui.theme.InAppUpdateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InAppUpdateTheme {
                Surface(color = MaterialTheme.colors.background) {
                    RequireLatestVersion {
                        MainContent()
                    }
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = "InApp Update",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "You have the latest version installed",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}





















