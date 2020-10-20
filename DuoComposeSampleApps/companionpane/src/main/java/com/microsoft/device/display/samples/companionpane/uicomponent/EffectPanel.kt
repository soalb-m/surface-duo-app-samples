package com.microsoft.device.display.samples.companionpane.uicomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.microsoft.device.display.samples.companionpane.R

@Composable
fun EffectPanel() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        ImageWithText(R.drawable.gingham, "Gingham")
        ImageWithText(R.drawable.orignal, "Original")
        ImageWithText(R.drawable.lark, "Lark")
        ImageWithText(R.drawable.juno, "Juno")
        ImageWithText(R.drawable.ludwig, "Ludwig")
    }
}

@Composable
fun ImageWithText(id: Int, text: String) {
    Column(modifier = Modifier.width(60.dp)) {
        Image(asset = imageResource(id = id),
              modifier = Modifier.width(60.dp))
        Text(text = text,
             textAlign = TextAlign.Center,
             color = Color.White,
             fontSize = 12.sp)
    }
}

@Composable
fun FilterControl() {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        IconsPanel()
        AdjustScale()
    }
}

@Composable
fun AdjustScale() {
    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
           verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Image(asset = imageResource(R.drawable.dot),
              modifier = Modifier.fillMaxWidth().height(5.dp),
              contentScale = ContentScale.Inside,
              alignment = Alignment.Center)
        Image(asset = imageResource(R.drawable.scale_icon),
              modifier = Modifier.fillMaxWidth().height(25.dp),
              contentScale = ContentScale.Inside,
              alignment = Alignment.Center)
    }
}

@Composable
fun IconsPanel() {
    Row(modifier = Modifier.fillMaxWidth().height(25.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Image(asset = imageResource(id = R.drawable.filter_icon))
        Image(asset = imageResource(id = R.drawable.hdr_icon))
        Image(asset = imageResource(id = R.drawable.ecllipse_icon))
        Image(asset = imageResource(id = R.drawable.vertical_icon))
        Image(asset = imageResource(id = R.drawable.horizontal_icon))
        Image(asset = imageResource(id = R.drawable.zoom_icon))
        Image(asset = imageResource(id = R.drawable.brightness_icon))
    }
}
