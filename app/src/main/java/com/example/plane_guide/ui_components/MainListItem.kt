package com.example.plane_guide.ui_components

import android.graphics.BitmapFactory
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plane_guide.ui.theme.MainRed
import com.example.plane_guide.ui.theme.Orange
import com.example.plane_guide.utils.ListItem as UtilsListItem

@Composable
fun MainListItem(item: UtilsListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, MainRed)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AssetImage(imageName = item.imageName,
                contentDescriptor = item.title)
            Text(
                text = item.title,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Orange)
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun AssetImage(imageName: String, contentDescriptor: String){
    val context = LocalContext.current
    val assetManager = context.assets
    val inputStream = assetManager.open(imageName)
    val bitMap = BitmapFactory.decodeStream(inputStream)
    Image(
        bitmap = bitMap.asImageBitmap(),
        contentDescription = contentDescriptor,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
        )
}
