package com.example.plane_guide.ui_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plane_guide.R
import com.example.plane_guide.ui.theme.BgTransparent
import com.example.plane_guide.ui.theme.Grey
import com.example.plane_guide.ui.theme.MainRed
import com.example.plane_guide.ui.theme.Orange
import com.example.plane_guide.utils.DrawerEvents

@Composable
fun DrawerMenu(onEvent: (DrawerEvents) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(
            id = R.drawable.drawer_list),
            contentDescription = "Main Bg image",
            modifier = Modifier
                .fillMaxSize()
                .background(Grey),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Header()
            Body(){event ->
                onEvent(event)
            }
        }
    }
}
@Composable
fun Header(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, MainRed)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = "Header image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Plane Guide",
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
fun Body(onEvent: (DrawerEvents) -> Unit){
    val list = stringArrayResource(id = R.array.drawer_list)
    LazyColumn(modifier = Modifier.fillMaxSize()){
        itemsIndexed(list){ index, title ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                    .clip(RoundedCornerShape(14.dp)),
                backgroundColor = BgTransparent
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .clickable {
                                onEvent(DrawerEvents.OnItemClick(title, index))
                            }
                            .padding(vertical = 25.dp)
                            .wrapContentWidth(),
                        fontWeight = FontWeight.Bold
                    )
                    if(index > 2) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            painterResource(id = R.drawable.fighter_plane),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DrawerMenuPreview() {
    DrawerMenu {
    }
}