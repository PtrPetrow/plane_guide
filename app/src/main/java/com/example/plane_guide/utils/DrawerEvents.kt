package com.example.plane_guide.utils

sealed class DrawerEvents {
    data class OnItemClick(val title: String, val index: Int): DrawerEvents()
}