package com.example.plane_guide.ui_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plane_guide.ui.theme.BgTransparent
import com.example.plane_guide.ui.theme.MainRed
import kotlinx.coroutines.launch

@Composable
fun MainTopBar(title: String, scaffoldState: ScaffoldState) {
    val coroutine = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(text = title)
        },
        backgroundColor = BgTransparent,
        navigationIcon = {
            IconButton(
                onClick = {
                    coroutine.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            Row (modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.End){
                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(75.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(45.dp),
                        imageVector = Icons.Default.Favorite,
                        tint = MainRed,
                        contentDescription = "Favorite"
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun MainTopBarPreview() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MainTopBar(title = "4.44", scaffoldState = scaffoldState)}
    ) {
        Text(modifier = Modifier.padding(top = it.calculateTopPadding()), text = "Hi")
    }
}