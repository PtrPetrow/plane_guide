package com.example.plane_guide

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.plane_guide.ui.theme.Plane_guideTheme
import com.example.plane_guide.ui_components.DrawerMenu
import com.example.plane_guide.ui_components.MainListItem
import com.example.plane_guide.ui_components.MainTopBar
import com.example.plane_guide.utils.DrawerEvents
import com.example.plane_guide.utils.IdArrayList
import com.example.plane_guide.utils.ListItem
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val mainList = remember {
                mutableStateOf(getListItemsByIndex(0, this))
            }
            val coroutineScope = rememberCoroutineScope()
            val topBarTitle = remember {
                mutableStateOf("Boeing")
            }
            Plane_guideTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        MainTopBar(
                            title = topBarTitle.value,
                            scaffoldState
                        )
                    },
                    drawerContent = {
                        DrawerMenu(){event ->
                            when(event){
                                is DrawerEvents.OnItemClick -> {
                                    topBarTitle.value = event.title
                                    mainList.value = getListItemsByIndex(
                                        event.index,
                                        this@MainActivity)
                                }
                            }
                            coroutineScope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    }
                ) {
                    LazyColumn (modifier = Modifier.fillMaxSize()){
                        items(mainList.value){item ->
                            MainListItem(item = item)
                        }
                   }
                }
            }
        }
    }
}
private fun getListItemsByIndex(index: Int, context: Context): List<ListItem> {
    val list = ArrayList<ListItem>()
    val arrayList = context.resources.getStringArray(IdArrayList.listId[index])
    arrayList.forEach { item ->
        val itemArray = item.split("|")
        list.add(
            ListItem(
                itemArray[0],
                itemArray[1]
            )
        )
    }
    return list
}