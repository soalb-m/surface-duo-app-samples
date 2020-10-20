/*
 *
 *  * Copyright (c) Microsoft Corporation. All rights reserved.
 *  * Licensed under the MIT License.
 *  *
 *
 */

package com.microsoft.device.display.samples.companionpane.uicomponent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.microsoft.device.display.samples.companionpane.R

@Composable
fun MagicDefinitionPanel() {
    Column {
        MagicWandPanel()
        DefinitionPanel()
    }
}

@Composable
fun MagicWandPanel() {
    Row() {
        ImageWithText(R.drawable.filter_icon, "Magic Wand", 30.dp)
        SliderControl()
    }
}

@Composable
fun DefinitionPanel() {
    Row() {
        ImageWithText(R.drawable.hdr_icon, "Definition", 30.dp)
        SliderControl()
    }
}

@Composable
fun VignetteBrightnessPanel() {
    Column {
        VignettePanel()
        BrightnessPanel()
    }
}

@Composable
fun VignettePanel() {
    Row() {
        ImageWithText(R.drawable.zoom_icon, "Vignette", 30.dp)
        SliderControl()
    }
}

@Composable
fun BrightnessPanel() {
    Row() {
        ImageWithText(R.drawable.brightness_icon, "Brightness", 30.dp)
        SliderControl()
    }
}