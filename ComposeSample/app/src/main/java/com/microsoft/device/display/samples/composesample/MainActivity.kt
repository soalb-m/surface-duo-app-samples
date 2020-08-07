/*
 *
 *  * Copyright (c) Microsoft Corporation. All rights reserved.
 *  * Licensed under the MIT License.
 *
 */

package com.microsoft.device.display.samples.composesample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import androidx.core.util.Consumer
import androidx.lifecycle.ViewModelProvider
import androidx.window.WindowLayoutInfo
import androidx.window.WindowManager
import com.microsoft.device.display.samples.composesample.ui.DuoSDKSampleAppsTheme
import com.microsoft.device.display.samples.composesample.viewModels.AppStateViewModel
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    private lateinit var windowManager: WindowManager
    private lateinit var appStateViewModel: AppStateViewModel

    private val handler = Handler(Looper.getMainLooper())
    val mainThreadExecutor = Executor { r: Runnable -> handler.post(r) }
    private val layoutStateChangeCallback = LayoutStateChangeCallback()

    override fun onCreate(savedInstanceState: Bundle?) {
        windowManager = WindowManager(this, null)
        appStateViewModel = ViewModelProvider(this).get(AppStateViewModel::class.java)

        super.onCreate(savedInstanceState)

        setContent {
            DuoSDKSampleAppsTheme {
                Home(appStateViewModel)
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        windowManager.registerLayoutChangeCallback(mainThreadExecutor, layoutStateChangeCallback)
        Log.i("ComposeSample", "onAttachedToWindow")

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        windowManager.unregisterLayoutChangeCallback(layoutStateChangeCallback)
    }

    inner class LayoutStateChangeCallback : Consumer<WindowLayoutInfo> {
        override fun accept(newLayoutInfo: WindowLayoutInfo) {
            val isAppSpanned = newLayoutInfo.displayFeatures.size > 0
            appStateViewModel.setIsScreenSpannedLiveData(isAppSpanned)
            Log.i("ComposeSample", "LayoutStateChangeCallback isScreenSpanned: $isAppSpanned")
        }
    }
}
