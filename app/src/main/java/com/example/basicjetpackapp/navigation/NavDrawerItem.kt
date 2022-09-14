package com.example.basicjetpackapp.navigation
import com.example.basicjetpackapp.R

sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
    object Home : NavDrawerItem("home", R.drawable.baseline_home_24, "Home")
    object Info : NavDrawerItem("info", R.drawable.baseline_info_24, "Info")
    object Profile : NavDrawerItem("profile", R.drawable.baseline_person_24, "Profile")
    object Settings : NavDrawerItem("settings", R.drawable.baseline_settings_24, "Settings")
}