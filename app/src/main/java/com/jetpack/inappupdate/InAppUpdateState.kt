package com.jetpack.inappupdate

import androidx.compose.runtime.Composable
import com.google.android.play.core.ktx.AppUpdateResult

interface InAppUpdateState {
    val appUpdateResult: AppUpdateResult
}

@Composable
fun rememberInAppUpdateState():InAppUpdateState {
    return rememberMutableInAppUpdateState()
}