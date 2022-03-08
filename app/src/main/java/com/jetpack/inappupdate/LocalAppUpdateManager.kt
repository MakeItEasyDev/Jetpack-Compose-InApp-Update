package com.jetpack.inappupdate

import androidx.compose.runtime.staticCompositionLocalOf
import com.google.android.play.core.appupdate.AppUpdateManager

internal val LocalAppUpdateManager = staticCompositionLocalOf<AppUpdateManager?> { null }