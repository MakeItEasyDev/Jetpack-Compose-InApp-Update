package com.jetpack.inappupdate

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.ktx.AppUpdateResult
import com.google.android.play.core.ktx.requestUpdateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
internal fun rememberMutableInAppUpdateState(): InAppUpdateState {
    val context = LocalContext.current
    val appUpdateManager = LocalAppUpdateManager.current ?: AppUpdateManagerFactory.create(context)
    val scope = rememberCoroutineScope()

    return remember { MutableInAppUpdateState(scope, appUpdateManager) }
}

internal class MutableInAppUpdateState(
    scope: CoroutineScope,
    private val appUpdateManager: AppUpdateManager
): InAppUpdateState {
    private var _appUpdateResult by mutableStateOf<AppUpdateResult>(AppUpdateResult.NotAvailable)

    override val appUpdateResult: AppUpdateResult
        get() = _appUpdateResult

    init {
        scope.launch {
            appUpdateManager.requestUpdateFlow().catch { e ->
                Log.e("Error", "Error: ", e)
            }.collect {
                _appUpdateResult = it
            }
        }
    }
}


















